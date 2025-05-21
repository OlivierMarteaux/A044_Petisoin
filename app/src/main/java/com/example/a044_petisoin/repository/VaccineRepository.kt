package com.example.a044_petisoin.repository

import com.example.a044_petisoin.dao.VaccineDao
import com.example.a044_petisoin.model.Vaccine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VaccineRepository @Inject constructor(private val vaccineDao: VaccineDao) {
    suspend fun insertVaccine(vaccine: Vaccine) {
        vaccineDao.insertVaccine(vaccine)
    }
    suspend fun updateVaccine(vaccine: Vaccine) {
        vaccineDao.updateVaccine(vaccine)
    }
    suspend fun deleteVaccine(vaccine: Vaccine) {
        vaccineDao.deleteVaccine(vaccine)
    }
    suspend fun getVaccineById(id: Int): Vaccine? {
        return vaccineDao.getVaccineById(id)
    }
    fun getAllVaccines(): Flow<List<Vaccine>> {
        return vaccineDao.getAllVaccines()
    }
}