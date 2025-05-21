package com.example.a044_petisoin.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "Note",
    foreignKeys = [
        ForeignKey(
            entity = Animal::class,
            parentColumns = ["id"],
            childColumns = ["animalId"]
        )
    ]
)
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val title: String = "",
    val content: String = "",
    val creationDate: Date = Date(),
    val animalId: Int = 0,
)
