package com.example.smarthausapp.data.remote.device

import ar.edu.itba.example.api.data.remote.device.RemoteDeviceState
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteCurtainsState : RemoteDeviceState {

    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("open")
    @Expose
    var open: Boolean = true

    @SerializedName("close")
    @Expose
    var close: Boolean = false

    @SerializedName("level")
    @Expose
    var level: Int = 0
}