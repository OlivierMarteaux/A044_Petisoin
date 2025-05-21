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
import com.example.a044_petisoin.model.Vaccine
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Date

@RunWith(AndroidJUnit4::class)
class VaccineDaoTest {

    private lateinit var database: PetisoinDatabase

    @Before
    // Given a database and an Vaccine :
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
    private val vaccine1 = Vaccine(
        id = 1,
        nom = "vaccine1",
        dateInjection = Date(),
        animalId = 1
    )
    private val vaccine2 = Vaccine(
        id = 2,
        nom = "vaccine2",
        dateInjection = Date(),
        animalId = 1
    )


    @Test
    fun vaccineDao_InsertVaccine_ReturnsCorrectVaccine() = runTest {
        // When the Vaccine is inserted into the database
        database.animalDao().insertAnimal(animal)
        database.vaccineDao().insertVaccine(vaccine1)
        // Then the Vaccine can be retrieved from the database
        val retrievedVaccine = database.vaccineDao().getVaccineById(1)
        assertEquals("inserted and retrieved Vaccine must be equals", vaccine1, retrievedVaccine)
    }

    @Test
    fun vaccineDao_UpdateVaccine_ReturnsCorrectVaccine() = runTest {
        // Given a Vaccine is inserted into the database
        database.animalDao().insertAnimal(animal)
        database.vaccineDao().insertVaccine(vaccine1)
        // When the Vaccine is updated in the database
        val updatedVaccine = vaccine1.copy(nom = "vaccine3")
        database.vaccineDao().updateVaccine(updatedVaccine)
        // Then the updated Vaccine can be retrieved from the database
        val retrievedVaccine = database.vaccineDao().getVaccineById(1)
        assertEquals("updated and retrieved Vaccine must be equals", updatedVaccine, retrievedVaccine)
    }

    @Test
    fun vaccineDao_DeleteVaccine_ReturnsNull() = runTest {
        // Given a Vaccine is inserted into the database
        database.animalDao().insertAnimal(animal)
        database.vaccineDao().insertVaccine(vaccine1)
        // When the Vaccine is deleted from the database
        database.vaccineDao().deleteVaccine(vaccine1)
        // Then the deleted Vaccine cannot be retrieved from the database
        val retrievedVaccine = database.vaccineDao().getVaccineById(1)
        assertEquals("deleted Vaccine must be null", null, retrievedVaccine)
    }

    @Test
    fun vaccineDao_GetAllVaccines_ReturnsCorrectList() = runTest {
        // Given two Vaccines are inserted into the database
        database.animalDao().insertAnimal(animal)
        val vaccines = listOf(vaccine1, vaccine2)
        vaccines.forEach { database.vaccineDao().insertVaccine(it) }
        // When all Vaccines are retrieved from the database
        database.vaccineDao().getAllVaccines().test {
            val retrievedVaccines = awaitItem()
            // Then the correct list of Vaccines is returned
            assertEquals("all Vaccines are retireved", vaccines, retrievedVaccines)
            // stop flow collecting
            cancel()
        }
    }

    @Test
    fun vaccineDao_GetAllVaccines_ReturnsEmptyList() = runTest {
        // When all Vaccines are retrieved from the database
        database.vaccineDao().getAllVaccines().test {
            val allVaccines = awaitItem()
            // Then an empty list is returned
            assertEquals("Vaccine database is empty", emptyList<Vaccine>(), allVaccines)
            // stop flow collecting
            cancel()
        }
    }

    @After
    fun closeDb() {
        database.close()
    }
}