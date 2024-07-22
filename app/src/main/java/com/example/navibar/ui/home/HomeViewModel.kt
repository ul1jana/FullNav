package com.example.navibar.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.navibar.ui.Book
import com.example.navibar.ui.BookDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val bookDao = BookDatabase.getDatabase(application).bookDao()
    val books: LiveData<List<Book>> = bookDao.getAllBooks()

    fun addBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            bookDao.insert(book)
        }
    }
}
