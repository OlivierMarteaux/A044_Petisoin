package com.example.a044_petisoin.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Animal")
data class Animal (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: AnimalType = AnimalType.DOG,
    val name: String? = null,
    val height: Int = 0,
    val weight: Int = 0,
    val age: Int = 0,
    @Embedded val adress: Address = Address(),
    val vaccine: Vaccine = Vaccine(),
)