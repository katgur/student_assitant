package com.example.student_assistant.ui.stateholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(repository: CardRepository) : ViewModel() {

    private val _cards = MutableLiveData(repository.getAll())
    val cards: LiveData<List<Card>> = _cards
}