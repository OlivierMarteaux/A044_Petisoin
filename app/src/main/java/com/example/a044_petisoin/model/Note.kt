package com.example.a044_petisoin.model

data class Note(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val creationDate: Long = 0L,
    val animalId: Int = 0,
)
