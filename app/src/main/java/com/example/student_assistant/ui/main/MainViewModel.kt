package com.example.student_assistant.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.CardWithProjectUseCase
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.ICardRepository
import kotlinx.coroutines.launch

class MainViewModel(private val cardWithProjectUseCase: CardWithProjectUseCase) : ViewModel() {

    private val _cards = MutableLiveData<List<Pair<Card, Project>>>(emptyList())
    val cards: LiveData<List<Pair<Card, Project>>> = _cards

    init {
        viewModelScope.launch {
            _cards.postValue(cardWithProjectUseCase.getAll())
        }
    }
}