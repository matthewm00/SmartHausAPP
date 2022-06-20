package com.example.smarthausapp.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.smarthausapp.R
import com.example.smarthausapp.databinding.AcItemBinding
import com.example.smarthausapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class DeviceActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        val item  = itemViewModel.selectedItem

        when(item.value){
            0 -> {
                val binding: AcItemBinding = AcItemBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

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