package com.example.navibar.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navibar.data.Book
import com.example.navibar.data.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    val books: LiveData<List<Book>> = repository.getAllBooks()

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }
}
