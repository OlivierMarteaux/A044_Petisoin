package com.example.a044_petisoin.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a044_petisoin.model.Address
import com.example.a044_petisoin.model.Animal
import com.example.a044_petisoin.model.AnimalType
import com.example.a044_petisoin.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(animalRepository: AnimalRepository): ViewModel() {

    private val animal = Animal(
        id = 1,
        type = AnimalType.DOG,
        name = "Fido",
        height = 100,
        weight = 50,
        age = 2,
        adress = Address(
            adress = "123 Main St",
            city = "Anytown",
            country = "USA"
        ),
    )
    private val animal2 = Animal(
        id = 2,
        type = AnimalType.CAT,
        name = "Buddy",
        height = 120,
        weight = 100,
        age = 4,
        adress = Address(
            adress = "123 Main St",
            city = "Anytown",
            country = "USA"
        )
    )
    init {
        viewModelScope.launch {
            animalRepository.insertAnimal(animal)
            animalRepository.insertAnimal(animal2)
        }
    }
    val animals = animalRepository.getAllAnimals()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}