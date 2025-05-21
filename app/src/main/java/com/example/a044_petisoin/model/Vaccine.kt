package com.example.a044_petisoin.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "Vaccine",
    foreignKeys = [
        ForeignKey(
            entity = Animal::class,
            parentColumns = ["id"],
            childColumns = ["animalId"]
        )
    ])
data class Vaccine(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val dateInjection: Date = Date(),
    val nom: String = "",
    val animalId: Int = 0,
)
