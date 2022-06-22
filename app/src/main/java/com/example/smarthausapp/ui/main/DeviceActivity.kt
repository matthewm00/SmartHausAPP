package com.example.smarthausapp.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.smarthausapp.R
import com.example.smarthausapp.databinding.*
import com.google.android.material.tabs.TabLayout

class DeviceActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        val item  = itemViewModel.selectedItem

        when(intent.extras?.get("card")){
            0 -> {
                val binding: AcItemBinding = AcItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
            1 -> {
                val binding: AspiradoraItemBinding = AspiradoraItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
            2 -> {
                val binding: CortinaItemBinding = CortinaItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
            3 -> {
                val binding: DoorItemBinding = DoorItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
            4 -> {
                val binding: FridgeItemBinding = FridgeItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.settings -> {
            // User chose the "Settings" item, show the app settings UI...
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}