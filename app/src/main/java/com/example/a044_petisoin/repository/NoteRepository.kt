package com.example.a044_petisoin.repository

import com.example.a044_petisoin.dao.NoteDao
import com.example.a044_petisoin.model.Note
import com.example.a044_petisoin.model.Vaccine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }
    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }
    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
    suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }
    fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }
}