package com.example.navibar.ui.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navibar.R
import com.example.navibar.data.Book
import com.example.navibar.data.BookDatabase
import com.example.navibar.data.BookRepository
import com.example.navibar.databinding.FragmentUploadBinding

class UploadFragment : Fragment() {

    private var _binding: FragmentUploadBinding? = null
    private val binding get() = _binding!!

    private val uploadViewModel: UploadViewModel by viewModels {
        UploadViewModelFactory(
            BookRepository(BookDatabase.getInstance(requireContext()).bookDao())
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val author = binding.editTextAuthor.text.toString()
            val pagesString = binding.editTextPages.text.toString()
            val description = binding.editTextDescription.text.toString()
            val comment = binding.editTextComment.text.toString()

            if (title.isNotBlank() && author.isNotBlank() && pagesString.isNotBlank()) {
                val pages = pagesString.toIntOrNull() ?: 0
                val book = Book(
                    title = title,
                    author = author,
                    pages = pages,          // Pass Int here
                    description = description,
                    comment = comment
                )
                uploadViewModel.insert(book)
                Toast.makeText(requireContext(), "Book saved", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_uploadFragment_to_homeFragment)
            } else {
                Toast.makeText(requireContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
