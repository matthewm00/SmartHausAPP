package ar.edu.itba.example.api.data

import androidx.lifecycle.LiveData

class AbsentLiveData<T> private constructor() : LiveData<T>() {
    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }

    init {
        postValue(null)
    }
}