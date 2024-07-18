package com.example.navibar.uiimport
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.navibar.R
import com.example.navibar.ui.Book

class BookAdapter(private val context: Context, private val books: ArrayList<Book>) : BaseAdapter() {

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Any {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val bookTitleTextView = view.findViewById<TextView>(R.id.bookTitleTextView)
        val bookAuthorTextView = view.findViewById<TextView>(R.id.bookAuthorTextView)

        val book = books[position]
        bookTitleTextView.text = book.title
        bookAuthorTextView.text = book.author

        return view
    }
}
