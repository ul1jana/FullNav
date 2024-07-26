package com.example.navibar.ui

import androidx.compose.ui.window.application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navibar.ui.Book
import com.example.navibar.ui.BookDao
import kotlinx.coroutines.launch

class BookViewModel(private val bookDao: BookDao) : ViewModel() {

    val allBooks: LiveData<List<Book>> = bookDao.getAllBooks()

    fun addBook(book: Book) {
        viewModelScope.launch {
            bookDao.insert(book)
        }
    }
    private val repository: BookRepository = BookRepository(bookDao)

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }
}
