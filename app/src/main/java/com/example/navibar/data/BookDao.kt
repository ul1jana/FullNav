package com.example.navibar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM book_table ORDER BY title ASC")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE id = :id")
    fun getBookById(id: Int): LiveData<Book?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()
}