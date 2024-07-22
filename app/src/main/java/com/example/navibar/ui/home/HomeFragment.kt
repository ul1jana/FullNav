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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize HomeViewModel using HomeViewModelFactory
        homeViewModel = ViewModelProvider(this, HomeViewModelFactory(requireActivity().application))
            .get(HomeViewModel::class.java)

        // Initialize ListView and Adapter
        bookListView = root.findViewById(R.id.bookListView)
        bookAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, mutableListOf())
        bookListView.adapter = bookAdapter

        // Observe books from ViewModel
        homeViewModel.books.observe(viewLifecycleOwner) { books ->
            val bookTitles = books.map { "${it.title} by ${it.author}" }
            bookAdapter.clear()
            bookAdapter.addAll(bookTitles)
            bookAdapter.notifyDataSetChanged()
        }

        return root
    }
}
