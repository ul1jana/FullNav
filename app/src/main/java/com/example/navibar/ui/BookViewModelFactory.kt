package com.example.navibar.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.ui.BookDao
import com.example.navibar.ui.BookViewModel

class BookViewModelFactory(private val bookDao: BookDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookViewModel(bookDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
