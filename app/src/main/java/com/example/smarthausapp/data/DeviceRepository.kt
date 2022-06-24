package com.example.smarthausapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import ar.edu.itba.example.api.data.AppExecutors
import ar.edu.itba.example.api.data.NetworkBoundResource
import ar.edu.itba.example.api.data.Resource
import ar.edu.itba.example.api.data.remote.ApiResponse
import ar.edu.itba.example.api.data.remote.RemoteResult
import ar.edu.itba.example.api.data.remote.device.ApiDeviceService
import ar.edu.itba.example.api.data.remote.device.RemoteDevice
import java.util.function.Function
import java.util.stream.Collectors

class DeviceRepository(private val executors: AppExecutors, service: ApiDeviceService) {
//    private val service: ApiDeviceService
//    private fun mapDeviceRemoteToModel(remote: RemoteDevice): Device {
//        return Device(
//            remote.id,
//            remote.name!!,
//            remote.meta!!.,
//            remote.meta!!.color
//        )
//    }
//
//    private fun mapRoomModelToRemote(model: Device): RemoteDevice {
//        val remoteMeta = RemoteDeviceMeta()
//        remoteMeta.size = model.size
//        remoteMeta.color = model.color
//        val remote = RemoteDevice()
//        remote.id = model.id
//        remote.name = model.name
//        remote.meta = remoteMeta
//        return remote
//    }
//
//    val rooms: LiveData<Resource<List<Device>>>
//        get() {
//            Log.d(TAG, "RoomRepository - getRooms()")
//            return object : NetworkBoundResource<List<Device>, List<RemoteDevice>>(
//                executors,
//                Function<List<RemoteDevice>, List<Device>> { remotes: List<RemoteDevice> ->
//                    remotes.stream()
//                        .map { remote: RemoteDevice ->
//                            mapDeviceRemoteToModel(
//                                remote
//                            )
//                        }
//                        .collect(Collectors.toList())
//                }) {
//                override fun createCall(): LiveData<ApiResponse<RemoteResult<List<RemoteDevice>>>> {
//                    return service.getDevices()
//                }
//            }.asLiveData()
//        }
//
//    fun getDevice(roomId: String): LiveData<Resource<Device>> {
//        Log.d(TAG, "getDevice()")
//        return object : NetworkBoundResource<Device, RemoteDevice>(
//            executors, Function<RemoteDevice, Device> { remote: RemoteDevice ->
//                mapDeviceRemoteToModel(
//                    remote
//                )
//            }) {
//            override fun createCall(): LiveData<ApiResponse<RemoteResult<RemoteDevice>>> {
//                return service.getDevice(roomId)
//            }
//        }.asLiveData()
//    }
//
//    companion object {
//        private const val TAG = "data"
//    }
//
//    init {
//        this.service = service
//    }
}