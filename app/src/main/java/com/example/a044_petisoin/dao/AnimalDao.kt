package com.example.a044_petisoin.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.a044_petisoin.model.Animal

@Dao
interface AnimalDao {
    @Upsert
    suspend fun insertAnimal(animal: Animal)
    @Update
    suspend fun updateAnimal(animal: Animal)
    @Delete
    suspend fun deleteAnimalById(animal: Animal)

    @Query("SELECT * FROM Animal WHERE id = :id")
    suspend fun getAnimalById(id: Int): Animal?
    @Query("SELECT * FROM Animal")
    suspend fun getAllAnimals(): List<Animal>
}