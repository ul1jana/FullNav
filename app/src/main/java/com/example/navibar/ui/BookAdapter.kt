package com.example.navibar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navibar.R


class BookAdapter(private val onClick: (Book) -> Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var books: List<Book> = emptyList()

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)

        fun bind(book: Book) {
            titleTextView.text = book.title
            authorTextView.text = book.author
            itemView.setOnClickListener { onClick(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

    fun submitList(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }
}
