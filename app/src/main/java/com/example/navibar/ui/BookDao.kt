package com.example.navibar.ui

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAllBooks(): LiveData<List<Book>>

    @Insert
    suspend fun insert(book: Book)
}
