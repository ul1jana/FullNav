package com.example.navibar.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.data.BookRepository
import com.example.navibar.ui.home.HomeViewModel

class BookViewModelFactory(
    private val repository: BookRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}