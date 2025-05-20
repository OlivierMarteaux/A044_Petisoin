package com.example.a044_petisoin.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.a044_petisoin.model.Note

@Dao
interface NoteDao {
    @Upsert
    suspend fun insertNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?
    @Query("SELECT * FROM Note")
    suspend fun getAllNotes(): List<Note>
}