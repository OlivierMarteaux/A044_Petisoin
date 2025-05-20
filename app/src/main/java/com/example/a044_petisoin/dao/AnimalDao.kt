package com.example.a044_petisoin.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.a044_petisoin.model.Animal

// insert, get, update, and delete
interface AnimalDao {
    @Insert
    suspend fun insertAnimal(animal: Animal)
    @Query("SELECT * FROM Animal WHERE id = :id")
    suspend fun getAnimalById(id: Int): Animal?
    @Query("UPDATE Animal SET name = :name WHERE id = :id")
    suspend fun updateAnimalName(id: Int, name: String)
    @Query("SELECT * FROM Animal")
    suspend fun getAllAnimals(): List<Animal>
    @Query("DELETE FROM Animal WHERE id = :id")
    suspend fun deleteAnimalById(id: Int)
}