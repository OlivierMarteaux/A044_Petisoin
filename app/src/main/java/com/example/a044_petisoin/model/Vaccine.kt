package com.example.a044_petisoin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vaccine")
data class Vaccine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dateInjection: Long = 0L,
    val nom: String = "",
)
