package com.example.navibar.ui.upload

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.navibar.R
import com.example.navibar.ui.Book
import com.example.navibar.uiimport.BookAdapter



class UploadFragment : Fragment() {

    private lateinit var bookAdapter: BookAdapter
    private val books = ArrayList<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_upload, container, false)

        val bookListView = root.findViewById<ListView>(R.id.bookListView)
        val addButton = root.findViewById<Button>(R.id.addButton)

        bookAdapter = BookAdapter(requireContext(), books)
        bookListView.adapter = bookAdapter

        addButton.setOnClickListener {
            showAddBookDialog()
        }
        val uri = activity?.intent?.data
        if (uri!=null){
            showAddBookDialog()
        }

        return root
    }

    private fun showAddBookDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_add_book, null)
        val editTextTitle = dialogLayout.findViewById<EditText>(R.id.editTextTitle)
        val editTextAuthor = dialogLayout.findViewById<EditText>(R.id.editTextAuthor)

        with(builder) {
            setTitle("Add Book")
            setView(dialogLayout)
            setPositiveButton("Add") { dialog, _ ->
                val title = editTextTitle.text.toString()
                val author = editTextAuthor.text.toString()
                if (title.isNotEmpty() && author.isNotEmpty()) {
                    books.add(Book(title, author))
                    bookAdapter.notifyDataSetChanged()
                }
                dialog.dismiss()
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            show()
        }
    }
}
