package com.example.smarthausapp.ui.main

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smarthausapp.R

class ItemViewModel : ViewModel() {

    private val mutableSelectedItem = MutableLiveData<Int>()
    val selectedItem: LiveData<Int> get() = mutableSelectedItem

    fun selectItem(position: Int) {
        mutableSelectedItem.value = position
    }
}