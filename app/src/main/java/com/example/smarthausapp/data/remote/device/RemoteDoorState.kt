package com.example.smarthausapp.data.remote.device

import ar.edu.itba.example.api.data.remote.device.RemoteDeviceState
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteDoorState : RemoteDeviceState {

    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("open")
    @Expose
    var open: Boolean = true

    @SerializedName("close")
    @Expose
    var close: Boolean = false

    @SerializedName("lock")
    @Expose
    var lock: Boolean = true

    @SerializedName("unlock")
    @Expose
    var unlock: Boolean = false
}