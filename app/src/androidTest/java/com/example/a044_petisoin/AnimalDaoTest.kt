package com.example.a044_petisoin

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
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
    fun createDb () {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room
            .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), PetisoinDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @Test
    fun animalDao_InsertAnimal_ReturnsCorrectAnimal() = runTest {
        // Given a database and an animal
        val animal = Animal(
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
        // When the animal is inserted into the database
        database.animalDao().insertAnimal(animal)
        // Then the animal can be retrieved from the database
        val retrievedAnimal = database.animalDao().getAnimalById(1)
        assertEquals(animal, retrievedAnimal)
    }

    @After
    fun closeDb() {
        database.close()
    }
}