package ar.edu.itba.example.api.data.remote.device

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteDeviceType {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("powerUsage")
    @Expose
    var powerUsage: Int? = null

    companion object {
        const val LAMP_DEVICE_TYPE_ID = "go46xmbqeomjrsjr"
    }
}