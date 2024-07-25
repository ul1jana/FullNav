package com.example.navibar.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navibar.ui.Book
import com.example.navibar.ui.BookDao
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: BookDao) : ViewModel() {
    // LiveData object for observing the list of books
    @Suppress("UNCHECKED_CAST")
    fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
    val allBooks: LiveData<List<Book>> = repository.getAllBooks()

    // Method to fetch all books from the repository (not necessarily needed if using LiveData)
    fun fetchAllBooks() {
        viewModelScope.launch {
            // If you're using LiveData, fetching is handled automatically
            // repository.getAllBooks() - Fetching is handled via LiveData observer
        }
    }
}
