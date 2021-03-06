package com.example.smarthausapp.data.remote.device

import ar.edu.itba.example.api.data.remote.device.RemoteDeviceState
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteFridgeState : RemoteDeviceState {

    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("mode")
    @Expose
    lateinit var mode: String

    @SerializedName("setFreezerTemperature")
    @Expose
    var freezerTemperature: Int = 0

    @SerializedName("setTemperature")
    @Expose
    var temperature: Int = 0
}