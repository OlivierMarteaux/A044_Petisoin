package com.example.a044_petisoin.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a044_petisoin.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(animalRepository: AnimalRepository): ViewModel() {
    val animals = animalRepository.getAllAnimals().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

}