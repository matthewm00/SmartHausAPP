package ar.edu.itba.example.api.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteResult<T : Any> {
    @SerializedName("result")
    @Expose
    lateinit var result: T
}