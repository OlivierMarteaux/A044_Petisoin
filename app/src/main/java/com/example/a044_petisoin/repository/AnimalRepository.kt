package com.example.a044_petisoin.repository

import com.example.a044_petisoin.dao.AnimalDao
import com.example.a044_petisoin.model.Animal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimalRepository @Inject constructor(private val animalDao: AnimalDao) {
    suspend fun insertAnimal(animal: Animal) {
        animalDao.insertAnimal(animal)
    }
    suspend fun updateAnimal(animal: Animal) {
        animalDao.updateAnimal(animal)
    }
    suspend fun deleteAnimal(animal: Animal) {
        animalDao.deleteAnimal(animal)
        }
    suspend fun getAnimalById(id: Int): Animal? {
        return animalDao.getAnimalById(id)
    }
    fun getAllAnimals(): Flow<List<Animal>> {
        return animalDao.getAllAnimals()
    }
}