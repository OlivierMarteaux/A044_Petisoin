package com.example.a044_petisoin.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.a044_petisoin.model.Vaccine

//insert, get, update, and delete
interface VaccineDao {
    @Insert
    suspend fun insertVaccine(vaccine: Vaccine)
    @Query("SELECT * FROM Vaccine WHERE id = :id")
    suspend fun getVaccineById(id: Int): Vaccine?
    @Query("UPDATE Vaccine SET nom = :nom WHERE id = :id")
    suspend fun updateVaccine(id: Int, nom: String)
    @Query("SELECT * FROM Vaccine")
    suspend fun getAllVaccines(): List<Vaccine>
    @Query("DELETE FROM Vaccine WHERE id = :id")
    suspend fun deleteVaccineById(id: Int)
}