package com.example.student_assistant.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.domain.repository.IProjectRepository
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class ProjectViewModel @Inject constructor(private val repository: ICardRepository) : ViewModel() {

    private val _project = MutableLiveData<Project>(Project(0, "Test", "abcdefghijklmnop", 12345,
        123456, 2, 123, 0))
    val project: LiveData<Project> = _project

    fun addProject() {
        viewModelScope.launch {
            repository.addCard(Card(1, 1, 0, "abcdef"))
        }
    }
}