package com.example.navibar.data

import android.content.Context
import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {
        fun getAllBooks(): LiveData<List<Book>> = bookDao.getAllBooks()

        fun getBookById(id: Int): LiveData<Book?> = bookDao.getBookById(id)

        suspend fun insert(book: Book) {
            bookDao.insert(book)
        }

        companion object {
            @Volatile
            private var INSTANCE: BookRepository? = null

            fun getInstance(context: Context): BookRepository {
                return INSTANCE ?: synchronized(this) {
                    val instance = BookRepository(BookDatabase.getInstance(context).bookDao())
                    INSTANCE = instance
                    instance
                }
            }
        }
    }