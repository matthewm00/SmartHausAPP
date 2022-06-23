package ar.edu.itba.example.api.data.remote.device

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteLampState : RemoteDeviceState {
    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("color")
    @Expose
    lateinit var color: String

    @SerializedName("brightness")
    @Expose
    var brightness: Int = 0
}