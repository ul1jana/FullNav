package com.example.navibar.ui.bookdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.navibar.data.BookRepository
import com.example.navibar.databinding.FragmentBookDetailBinding
// BookDetailFragment.kt
class BookDetailFragment : Fragment() {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    private val bookDetailViewModel: BookDetailViewModel by viewModels {
        BookDetailViewModelFactory(BookRepository.getInstance(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val bookId = arguments?.getInt("bookId") ?: return root
        bookDetailViewModel.getBookById(bookId).observe(viewLifecycleOwner, { book ->
            book?.let {
                binding.textViewTitle.text = it.title
                binding.textViewAuthor.text = it.author
                binding.textViewPages.text = it.pages.toString()
                binding.textViewDescription.text = it.description
                binding.textViewComment.text = it.comment
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
