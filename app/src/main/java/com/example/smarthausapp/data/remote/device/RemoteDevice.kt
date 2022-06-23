package ar.edu.itba.example.api.data.remote.device

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class RemoteDevice<T : RemoteDeviceState> {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("type")
    @Expose(serialize = false)
    lateinit var type: RemoteDeviceType

    @SerializedName("room")
    var room = null

    @Expose(serialize = false)
    lateinit var state: T
        private set

    fun setState(state: T) {
        this.state = state
    }
}