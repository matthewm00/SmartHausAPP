package com.example.smarthausapp.ui.main

//import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smarthausapp.R
import com.example.smarthausapp.databinding.FragmentMainBinding


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var itemViewModel: ItemViewModel
    private var _binding: FragmentMainBinding? = null

    private lateinit var adapter: CustomAdapter
    private var dataSet = ArrayList<String>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java).apply {
            selectItem(0)
        }
    }

    private fun addItem(index: Int) {
        val itemText: String
        val device: String
        when(index) {
            1-> {
                device = resources.getString(R.string.ac_title)
                itemText = resources.getString(R.string.item_text, device)
            }
            2 -> {
                device = resources.getString(R.string.hoover_title)
                itemText = resources.getString(R.string.item_text, device)
            }
            3 -> {
                device = resources.getString(R.string.curtain_title)
                itemText = resources.getString(R.string.item_text, device)
            }
            4 -> {
                device = resources.getString(R.string.door_title)
                itemText = resources.getString(R.string.item_text, device)
            }
            5 -> {
                device = resources.getString(R.string.fridge_title)
                itemText = resources.getString(R.string.item_text, device)
            }
            else -> itemText = " "
        }
        dataSet.add(itemText)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        val textView: TextView = binding.sectionLabel

        for (i in 1..5) addItem(i)

        adapter = CustomAdapter(dataSet)
        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                itemViewModel.selectItem(position)
                Toast.makeText(this@PlaceholderFragment.context, "You clicked item $position \n ItemViewModel: ${itemViewModel.selectedItem.value}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@PlaceholderFragment.context, DeviceActivity::class.java)
                intent.putExtra("card", position)
                startActivity(intent)
            }
        })
        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerview.layoutManager = GridLayoutManager(this.context, 2)
        binding.recyclerview.adapter = adapter

        binding.fab.setOnClickListener {
            addItem(dataSet.size + 1)
            //adapter.notifyDataSetChanged();
            adapter.notifyItemInserted(dataSet.size)
        }

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}