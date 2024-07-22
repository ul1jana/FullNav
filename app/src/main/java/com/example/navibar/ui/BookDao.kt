package com.example.navibar.ui

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.example.navibar.ui.Book

@Dao
interface BookDao {
    fun getAllBooks(): LiveData<List<Book>>

    @Insert
    suspend fun insert(book: Book)
}
