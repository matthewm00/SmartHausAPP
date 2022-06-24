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
        const val AC_DEVICE_TYPE_ID = "li6cbv5sdlatti0j"
        const val HOOVER_DEVICE_TYPE_ID = "ofglvd9gqx8yfl3l"
        const val CURTAINS_DEVICE_TYPE_ID = "eu0v2xgprrhhg41g"
        const val DOOR_DEVICE_TYPE_ID = "lsf78ly0eqrjbz91"
        const val FRIDGE_DEVICE_TYPE_ID = "rnizejqr2di0okho"
    }
}