package ar.edu.itba.example.api.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoteError {
    @SerializedName("code")
    @Expose
    var code: Int

    @SerializedName("description")
    @Expose
    lateinit var description: List<String>

    constructor(code: Int) {
        this.code = code
    }

    constructor(code: Int, description: List<String>) {
        this.code = code
        this.description = description
    }

    companion object {
        const val LOCAL_UNEXPECTED_ERROR = 10
    }
}