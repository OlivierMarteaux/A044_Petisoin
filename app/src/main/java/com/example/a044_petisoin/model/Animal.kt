package com.example.a044_petisoin.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Animal (
    val id: Int,
    val type: String = "",
    val name: String? = null,
    val height: Int = 0,
    val weight: Int = 0,
    val age: Int = 0,
    val adress: Address = Address(),
    val vaccine: Vaccine = Vaccine(),
)