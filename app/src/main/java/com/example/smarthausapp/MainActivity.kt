package com.example.smarthausapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smarthausapp.ui.main.SectionsPagerAdapter
import com.example.smarthausapp.databinding.ActivityMainBinding
import com.example.smarthausapp.ui.main.CustomAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CustomAdapter
    private var dataSet = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

//        setContentView(R.layout.card_items)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        for (i in 1..6) addItem(i)

        adapter = CustomAdapter(dataSet)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.setLayoutManager(GridLayoutManager(this, 2));
        binding.recyclerview.adapter = adapter

        binding.fab.setOnClickListener {
            addItem(dataSet.size + 1)
            //adapter.notifyDataSetChanged();
            adapter.notifyItemInserted(dataSet.size)
        }

    }

    private fun addItem(index: Int) {
        val itemText = resources.getString(R.string.item_text, index)
        dataSet.add(itemText)
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