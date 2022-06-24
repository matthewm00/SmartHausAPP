package com.example.smarthausapp.data.remote.device

import ar.edu.itba.example.api.data.remote.device.RemoteDeviceState
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteACState : RemoteDeviceState {

    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("temperature")
    @Expose
    var temperature: Int = 24

    @SerializedName("mode")
    @Expose
    lateinit var mode: String

    @SerializedName("verticalSwing")
    @Expose
    lateinit var verticalSwing: String

    @SerializedName("horizontalSwing")
    @Expose
    lateinit var horizontalSwing: String

    @SerializedName("fanSpeed")
    @Expose
    lateinit var fanSpeed: String
}