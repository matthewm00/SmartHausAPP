package ar.edu.itba.example.api.data.remote

import ar.edu.itba.example.api.data.remote.device.RemoteDevice
import ar.edu.itba.example.api.data.remote.device.RemoteDeviceType
import ar.edu.itba.example.api.data.remote.device.RemoteLamp
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DeviceDeserializer : JsonDeserializer<RemoteDevice<*>?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): RemoteDevice<*>? {
        val gson = Gson()
        val jsonDeviceObject = json.asJsonObject
        val jsonDeviceTypeObject = jsonDeviceObject["type"].asJsonObject
        val deviceTypeId = jsonDeviceTypeObject["id"].asString
        return if (deviceTypeId == RemoteDeviceType.LAMP_DEVICE_TYPE_ID) {
            gson.fromJson(jsonDeviceObject, object : TypeToken<RemoteLamp?>() {}.type)
        } else null
    }
}