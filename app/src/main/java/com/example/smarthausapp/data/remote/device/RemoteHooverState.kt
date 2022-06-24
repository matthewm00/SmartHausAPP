package com.example.smarthausapp.data.remote.device

import ar.edu.itba.example.api.data.remote.device.RemoteDeviceState
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteHooverState : RemoteDeviceState {

    @SerializedName("status")
    @Expose
    lateinit var status: String

    @SerializedName("mode")
    @Expose
    lateinit var mode: String

    @SerializedName("location")
    @Expose
    lateinit var location: String

    @SerializedName("roomId")
    @Expose
    lateinit var roomId: String

    @SerializedName("batteryLevel")
    @Expose
    var battery: Int = 100

    @SerializedName("play")
    @Expose
    var open: Boolean = true

    @SerializedName("pause")
    @Expose
    var close: Boolean = false

    @SerializedName("dock")
    @Expose
    var dock: Boolean = true


}