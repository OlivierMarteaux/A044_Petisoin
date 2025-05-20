package com.example.a044_petisoin.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.a044_petisoin.model.Note

// insert, get, update and delete
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)
    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?
    @Query("UPDATE Note SET title = :title WHERE id = :id")
    suspend fun updateNoteTitle(id: Int, title: String)
    @Query("SELECT * FROM Note")
    suspend fun getAllNotes(): List<Note>
    @Query("DELETE FROM Note WHERE id = :id")
    suspend fun deleteNoteById(id: Int)
}