package com.example.navibar.ui.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.R
import com.example.navibar.ui.home.HomeViewModel
import com.example.navibar.ui.Book

class UploadFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_upload, container, false)

        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        val addButton: Button = root.findViewById(R.id.addButton)
        val bookTitleInput: EditText = root.findViewById(R.id.bookTitleInput)
        val bookAuthorInput: EditText = root.findViewById(R.id.bookAuthorInput)

        addButton.setOnClickListener {
            val title = bookTitleInput.text.toString().trim()
            val author = bookAuthorInput.text.toString().trim()

            if (title.isNotEmpty() && author.isNotEmpty()) {
                val book = Book(title = title, author = author)
                homeViewModel.addBook(book)
                Toast.makeText(requireContext(), "Book added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please enter both title and author", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }
}
