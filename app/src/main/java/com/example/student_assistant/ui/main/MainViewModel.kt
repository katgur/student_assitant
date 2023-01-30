package com.example.student_assistant.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.ICardRepository

class MainViewModel(repository: ICardRepository) : ViewModel() {

    private val _cards = MutableLiveData(repository.getAll())
    val cards: LiveData<List<Card>> = _cards
}