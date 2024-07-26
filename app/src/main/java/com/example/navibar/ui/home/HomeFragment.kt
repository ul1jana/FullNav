package com.example.navibar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navibar.R
import com.example.navibar.data.BookRepository
import com.example.navibar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(BookRepository.getInstance(requireContext()))
    }

    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bookAdapter = BookAdapter { book ->
            val action = HomeFragmentDirections.actionHomeFragmentToBookDetailFragment(book.id)
            findNavController().navigate(action)
        }

        binding.bookListView.adapter = bookAdapter

        homeViewModel.books.observe(viewLifecycleOwner, { books ->
            books?.let {
                bookAdapter.submitList(it)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

