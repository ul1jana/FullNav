package com.example.navibar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var bookListView: ListView
    private lateinit var bookAdapter: ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize HomeViewModel using HomeViewModelFactory
        homeViewModel = ViewModelProvider(
            // Provide the activity's application context to the ViewModelFactory
            owner = this,
            factory = HomeViewModelFactory(requireActivity().application)
        )[HomeViewModel::class.java]

        // Initialize ListView and Adapter
        bookListView = root.findViewById(R.id.bookListView)
        // Create an ArrayAdapter with a simple list item layout and an empty lis
        bookAdapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1, mutableListOf())
        // Set the ArrayAdapter to the ListView
        bookListView.adapter = bookAdapter

        // Observe books from ViewModel
        homeViewModel.books.observe(viewLifecycleOwner) { books ->
            // Map books to a list of strings formatted as "Title by Author"
            val bookTitles = books.map { "${it.title} by ${it.author}" }
            // Clear the existing items in the adapter
            bookAdapter.clear()
            // Add the new list of book titles to the adapter
            bookAdapter.addAll(bookTitles)
            // Inflate the layout for this fragment
            bookAdapter.notifyDataSetChanged()
        }

        return root
    }
}
