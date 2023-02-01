package com.example.student_assistant.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Interest
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.entity.Status
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.domain.repository.IProjectRepository
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class ProjectViewModel @Inject constructor(private val repository: ICardRepository,
private val repository1: IProjectRepository) : ViewModel() {

    private val _project = MutableLiveData<Project>()
    val project: LiveData<Project> = _project

    fun addProject() {
        viewModelScope.launch {
            val project = Project(UUID.randomUUID().toString(),
                "Test", "abcdefghijklmnop", "01 февраля",
                "12 февраля", 2, "02 февраля", Status.VACANT, emptyList())
            repository1.addProject(project)
            repository.addCard(Card(UUID.randomUUID().toString(), project.id, "", "abcdef"))
        }
    }
}