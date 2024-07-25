package com.example.navibar.ui

import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {

    fun getAllBooks(): LiveData<List<Book>> {
        return bookDao.getAllBooks() // Return LiveData directly
    }

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }


}
