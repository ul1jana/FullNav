package com.example.navibar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.databinding.FragmentHomeBinding
import com.example.navibar.ui.BookAdapter
import com.example.navibar.ui.BookDatabase
import com.example.navibar.ui.BookRepository

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize BookRepository and HomeViewModel
        val bookDao = BookDatabase.getDatabase(requireContext()).bookDao()
        val repository = BookRepository(requireActivity().application)
        val factory = HomeViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        // Observe LiveData
        homeViewModel.allBooks.observe(viewLifecycleOwner) { books ->
            // Update your UI with the list of books
            binding.bookListView.adapter = BookAdapter(books)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
