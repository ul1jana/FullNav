package com.example.navibar.ui.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.ui.Book
import com.example.navibar.ui.BookDatabase
import com.example.navibar.databinding.FragmentUploadBinding
import com.example.navibar.ui.BookViewModel
import com.example.navibar.ui.home.BookViewModelFactory

class UploadFragment : Fragment() {

    private var _binding: FragmentUploadBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dao = BookDatabase.getDatabase(requireContext()).bookDao()
        val factory = BookViewModelFactory(dao)
        bookViewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)

        binding.addButton.setOnClickListener {
            val title = binding.bookTitleInput.toString()
            val author = binding.bookAuthorInput.toString()
            val pages = binding.bookPagesInput.toString().toIntOrNull() ?: 0
            val description = binding.bookDescriptionInput.toString()
            val comments = binding.bookCommentsInput.toString()

            val book = Book(title = title, author = author, pages = pages, description = description, comment = comments)
            bookViewModel.insert(book)

            // Optionally, navigate back or show a message
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
