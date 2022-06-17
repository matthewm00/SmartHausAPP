package com.example.smarthausapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smarthausapp.R
import com.example.smarthausapp.databinding.ActivityMainBinding
import com.example.smarthausapp.databinding.FragmentMainBinding
import com.example.smarthausapp.ui.main.CustomAdapter

private lateinit var adapter: CustomAdapter
private var dataSet = ArrayList<String>()
/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

//    // This property is only valid between onCreateView and
//    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 1..6) addItem(i)

        adapter = CustomAdapter(dataSet)
        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerview.setLayoutManager(GridLayoutManager(this.context, 2))
        binding.recyclerview.adapter = adapter

//        binding.fab.setOnClickListener {
//            addItem(dataSet.size + 1)
//            //adapter.notifyDataSetChanged();
//            adapter.notifyItemInserted(dataSet.size)
//        }

    }

    private fun addItem(index: Int) {
        val itemText = resources.getString(R.string.item_text, index)
        dataSet.add(itemText)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

//        val textView: TextView = binding.sectionLabel
//        pageViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    companion object {
        /**
         * Returns a new instance of this fragment for the given section
         */
        @JvmStatic
        fun newInstance(): PlaceholderFragment {
            return PlaceholderFragment().apply { arguments = Bundle() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}