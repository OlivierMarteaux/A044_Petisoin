package com.example.a044_petisoin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.a044_petisoin.dao.AnimalDao
import com.example.a044_petisoin.dao.NoteDao
import com.example.a044_petisoin.dao.VaccineDao
import com.example.a044_petisoin.model.Animal
import com.example.a044_petisoin.model.DateConverter
import com.example.a044_petisoin.model.Note
import com.example.a044_petisoin.model.Vaccine

@Database(entities = [Animal::class, Note::class, Vaccine::class], version = 1, exportSchema = true)
@TypeConverters(DateConverter::class)
abstract class PetisoinDatabase: RoomDatabase() {
    abstract val animalDao: AnimalDao
    abstract val noteDao: NoteDao
    abstract val vaccineDao: VaccineDao
}