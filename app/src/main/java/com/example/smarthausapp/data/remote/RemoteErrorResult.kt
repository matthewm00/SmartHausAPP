package ar.edu.itba.example.api.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteErrorResult {
    @SerializedName("error")
    @Expose
    lateinit var error: RemoteError
}