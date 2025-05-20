package com.example.a044_petisoin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    // singleton pour la création d'une instance unique de la base de données
    companion object {
        private var instance: PetisoinDatabase? = null
        fun getDatabase(context: Context): PetisoinDatabase {
            // si l'instance n'est pas nulle, on la retourne,
            // sinon on crée une nouvelle instance de la base de données
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    PetisoinDatabase::class.java,
                    "petisoin_database"
                ).build().also { instance = it }
            }
        }
    }

    abstract fun animalDao(): AnimalDao
    abstract fun noteDao(): NoteDao
    abstract fun vaccineDao(): VaccineDao
}