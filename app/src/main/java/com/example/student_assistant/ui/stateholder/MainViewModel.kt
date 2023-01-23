package com.example.student_assistant.ui.stateholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.student_assistant.data.repository.CardRepository
import com.example.student_assistant.domain.entity.Card

class MainViewModel(repository: CardRepository) : ViewModel() {

    private val _cards = MutableLiveData(repository.getAll())
    val cards: LiveData<List<Card>> = _cards
}