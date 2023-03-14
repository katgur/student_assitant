package com.example.student_assistant.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.CardWithProjectUseCase
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.entity.Status
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel(
    private val cardWithProjectUseCase: CardWithProjectUseCase,
) : ViewModel() {

    private val _cards = MutableLiveData<List<Pair<Card, Project>>>(emptyList())
    val cards: LiveData<List<Pair<Card, Project>>> = _cards

    init {
        viewModelScope.launch {
            _cards.postValue(cardWithProjectUseCase.getAll())
            val project = Project(UUID.randomUUID().toString(), "Проект", "Описание", "12 февраля", "14 февраля", 3, "11 февраля", Status.VACANT, listOf())
            val card = Card(UUID.randomUUID().toString(), project.id, "", "abcdef")
            cardWithProjectUseCase.add(project, card)
        }
    }

    fun setQuery(query: String) {
        viewModelScope.launch {
            val filtered = cardWithProjectUseCase.byNameAndDescription(query)
            _cards.postValue(filtered)
        }
    }
}