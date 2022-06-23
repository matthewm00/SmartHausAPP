package ar.edu.itba.example.api.data.remote.device

import androidx.lifecycle.LiveData
import ar.edu.itba.example.api.data.remote.ApiResponse
import ar.edu.itba.example.api.data.remote.RemoteResult
import retrofit2.http.*

interface ApiDeviceService {
    @GET("devices")
    fun getDevices(): LiveData<ApiResponse<RemoteResult<List<RemoteDevice<*>>>>>

    @POST("devices")
    fun addDevice(@Body device: RemoteDevice<*>): LiveData<ApiResponse<RemoteResult<RemoteDevice<*>>>>

    @GET("devices/{deviceId}")
    fun getDevice(@Path("deviceId") deviceId: String): LiveData<ApiResponse<RemoteResult<RemoteDevice<*>>>>

    @PUT("devices/{deviceId}")
    fun modifyDevice(
        @Path("deviceId") deviceId: String,
        @Body device: RemoteDevice<*>
    ): LiveData<ApiResponse<RemoteResult<Boolean>>>

    @DELETE("devices/{deviceId}")
    fun deleteDevice(@Path("deviceId") deviceId: String): LiveData<ApiResponse<RemoteResult<Boolean>>>
}