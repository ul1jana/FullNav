package com.example.navibar.ui.bookdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navibar.data.Book
import com.example.navibar.data.BookRepository
import kotlinx.coroutines.launch

class BookDetailViewModel(private val repository: BookRepository) : ViewModel() {

    fun getBookById(bookId: Int): LiveData<Book?> {
        return repository.getBookById(bookId)
    }
}
