package com.example.a044_petisoin

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.a044_petisoin.database.PetisoinDatabase
import org.junit.After
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class VaccineDaoTest {

    private lateinit var database: PetisoinDatabase

    @Before
    fun createDb () {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room
            .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), PetisoinDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }


    @After
    fun closeDb() {
        database.close()
    }
}