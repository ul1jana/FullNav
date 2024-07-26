package com.example.navibar.ui.upload

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navibar.data.BookRepository

class UploadViewModelFactory(private val bookRepository: BookRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UploadViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UploadViewModel(bookRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
