package com.example.a044_petisoin

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.example.a044_petisoin.database.PetisoinDatabase
import com.example.a044_petisoin.model.Address
import com.example.a044_petisoin.model.Animal
import com.example.a044_petisoin.model.AnimalType
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class AnimalDaoTest {

    private lateinit var database: PetisoinDatabase

    @Before
    // Given a database and an animal :
    fun createDb () {
        database = Room
            .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), PetisoinDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
    private val animal = Animal(
        id = 1,
        type = AnimalType.DOG,
        name = "Fido",
        height = 100,
        weight = 50,
        age = 2,
        adress = Address(
            adress = "123 Main St",
            city = "Anytown",
            country = "USA"
        ),
    )
    private val animal2 = Animal(
        id = 2,
        type = AnimalType.CAT,
        name = "Buddy",
        height = 120,
        weight = 100,
        age = 4,
        adress = Address(
            adress = "123 Main St",
            city = "Anytown",
            country = "USA"
        )
    )

    @Test
    fun animalDao_InsertAnimal_ReturnsCorrectAnimal() = runTest {
        // When the animal is inserted into the database
        database.animalDao().insertAnimal(animal)
        // Then the animal can be retrieved from the database
        val retrievedAnimal = database.animalDao().getAnimalById(1)
        assertEquals("inserted and retrieved animal must be equals", animal, retrievedAnimal)
    }

    @Test
    fun animalDao_UpdateAnimal_ReturnsCorrectAnimal() = runTest {
        // Given an animal is inserted into the database
        database.animalDao().insertAnimal(animal)
        // When the animal is updated in the database
        val updatedAnimal = animal.copy(name = "Buddy")
        database.animalDao().updateAnimal(updatedAnimal)
        // Then the updated animal can be retrieved from the database
        val retrievedAnimal = database.animalDao().getAnimalById(1)
        assertEquals("updated and retrieved animal must be equals", updatedAnimal, retrievedAnimal)
    }

    @Test
    fun animalDao_DeleteAnimal_ReturnsNull() = runTest {
        // Given an animal is inserted into the database
        database.animalDao().insertAnimal(animal)
        // When the animal is deleted from the database
        database.animalDao().deleteAnimal(animal)
        // Then the deleted animal cannot be retrieved from the database
        val retrievedAnimal = database.animalDao().getAnimalById(1)
        assertEquals("deleted animal must be null", null, retrievedAnimal)
    }

    @Test
    fun animalDao_GetAllAnimals_ReturnsCorrectList() = runTest {
        // Given two animals are inserted into the database
        val animals = listOf(animal, animal2)
        animals.forEach { database.animalDao().insertAnimal(it) }
        // When all animals are retrieved from the database
        database.animalDao().getAllAnimals().test {
            val retrievedAnimals = awaitItem()
            // Then the correct list of animals is returned
            assertEquals("all animals are retireved", animals, retrievedAnimals)
            // stop flow collecting
            cancel()
        }
    }

    @Test
    fun animalDao_GetAllAnimals_ReturnsEmptyList() = runTest {
        // When all animals are retrieved from the database
        database.animalDao().getAllAnimals().test {
            val allAnimals = awaitItem()
            // Then an empty list is returned
            assertEquals("animal database is empty", emptyList<Animal>(), allAnimals)
            // stop flow collecting
            cancel()
        }
    }

    @After
    fun closeDb() {
        database.close()
    }
}