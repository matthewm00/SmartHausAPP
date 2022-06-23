package ar.edu.itba.example.api.data.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import java.io.IOException

class ApiResponse<T> {
    var data: T? = null
    var error: RemoteError? = null

    constructor(response: Response<T>) {
        parseResponse(response)
    }

    constructor(throwable: Throwable) {
        error = buildError(throwable.message)
    }

    private fun parseResponse(response: Response<T>) {
        if (response.isSuccessful) {
            data = response.body()!!
            return
        }
        if (response.errorBody() == null) {
            error = buildError("Missing error body")
            return
        }
        val message: String
        try {
            message = response.errorBody()!!.string()
        } catch (exception: IOException) {
            Log.e("API", exception.toString())
            error = buildError(exception.message)
            return
        }
        if (message.trim().isNotEmpty()) {
            val gson = Gson()
            val errorResult: RemoteErrorResult =
                gson.fromJson(message, object : TypeToken<RemoteErrorResult?>() {}.type)
            error = errorResult.error
        }
    }

    companion object {
        private fun buildError(message: String?): RemoteError {
            val error = RemoteError(RemoteError.LOCAL_UNEXPECTED_ERROR)
            if (message != null) {
                val description: MutableList<String> = ArrayList()
                description.add(message)
                error.description = description
            }
            return error
        }
    }
}