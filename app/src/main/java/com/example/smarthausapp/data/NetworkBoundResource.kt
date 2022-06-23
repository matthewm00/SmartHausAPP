package ar.edu.itba.example.api.data

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import ar.edu.itba.example.api.data.remote.ApiResponse
import ar.edu.itba.example.api.data.remote.RemoteResult
import java.util.function.Function

abstract class NetworkBoundResource<ModelType: Any, RemoteType: Any> @MainThread constructor(
    private val appExecutors: AppExecutors,
    private val mapRemoteToModel: Function<RemoteType, ModelType>
) {
    private val result: MediatorLiveData<Resource<ModelType>> =
        MediatorLiveData<Resource<ModelType>>()

    @MainThread
    private fun setValue(newValue: Resource<ModelType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork() {
        Log.d(TAG, "NetworkBoundResource - fetching API")
        val apiResponse: LiveData<ApiResponse<RemoteResult<RemoteType>>> = createCall()
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            if (response.error != null) {
                Log.d(
                    TAG,
                    "NetworkBoundResource - processing fetch error"
                )
                onFetchFailed()
                val modelError: ar.edu.itba.example.api.model.Error =
                    ar.edu.itba.example.api.model.Error(
                        response.error!!.code,
                        response.error!!.description[0]
                    )
                setValue(Resource.error(modelError))
            } else {
                Log.d(
                    TAG,
                    "NetworkBoundResource - processing fetch response"
                )
                val remote = processResponse(response)
                appExecutors.mainThread().execute {
                    val model = mapRemoteToModel.apply(remote)
                    setValue(Resource.success(model))
                }
            }
        }
    }

    protected fun onFetchFailed() {}
    fun asLiveData(): LiveData<Resource<ModelType>> {
        return result
    }

    @WorkerThread
    protected fun processResponse(response: ApiResponse<RemoteResult<RemoteType>>): RemoteType {
        return response.data!!.result
    }

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RemoteResult<RemoteType>>>

    companion object {
        private const val TAG = "data"
    }

    init {
        result.value = Resource.loading(null)
        Log.d(TAG, "NetworkBoundResource - fetchFromNetwork()")
        fetchFromNetwork()
    }
}