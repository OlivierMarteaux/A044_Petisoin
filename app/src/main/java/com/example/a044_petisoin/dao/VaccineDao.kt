package com.example.a044_petisoin.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.a044_petisoin.model.Vaccine
import kotlinx.coroutines.flow.Flow

@Dao
interface VaccineDao {
    @Upsert
    suspend fun insertVaccine(vaccine: Vaccine)
    @Update
    suspend fun updateVaccine(vaccine: Vaccine)
    @Delete
    suspend fun deleteVaccine(vaccine: Vaccine)

    @Query("SELECT * FROM Vaccine WHERE id = :id")
    suspend fun getVaccineById(id: Int): Vaccine?
    @Query("SELECT * FROM Vaccine")
    // no suspend function  if flow return type
    fun getAllVaccines(): Flow<List<Vaccine>>
}