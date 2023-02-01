package com.example.student_assistant.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.ICardRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ICardRepository) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>(emptyList())
    val cards: LiveData<List<Card>> = _cards

    init {
        viewModelScope.launch {
            _cards.postValue(repository.getAll())
        }
    }

}