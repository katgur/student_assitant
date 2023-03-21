package com.example.student_assistant.ui.project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.CreateProjectInfo
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.entity.Status
import com.example.student_assistant.domain.repository.IProjectRepository
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class ProjectViewModel @Inject constructor(
    private val repository: IProjectRepository,
) : ViewModel() {

    private val _project = MutableLiveData<Project>()
    val project: LiveData<Project> = _project
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message
    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> = _id
    private val _updated = MutableLiveData<Boolean>()
    val updated: LiveData<Boolean> = _updated

    fun setId(id: Int) {
        _id.value = id
        if (id != -1) {
            viewModelScope.launch {
                val result = repository.getProject(id)
                if (result.isSuccess) {
                    _project.postValue(result.getOrNull())
                } else {
                    _message.postValue(result.exceptionOrNull()?.message)
                }
            }
        }
    }

    fun addProject(
        title: String,
        description: String,
        maxNumberOfStudents: Int,
        recruitingStatus: String,
        projectStatus: String,
        applicationsDeadline: String,
        plannedStartOfWork: String,
        plannedFinishOfWork: String,
    ) {
        if (id.value != null && id.value != -1) {
            update(
                id.value!!,
                title,
                description,
                recruitingStatus,
                projectStatus,
                applicationsDeadline,
                plannedStartOfWork,
                plannedFinishOfWork,
            )
        } else {
            add(
                title,
                description,
                maxNumberOfStudents,
                recruitingStatus,
                projectStatus,
                applicationsDeadline,
                plannedStartOfWork,
                plannedFinishOfWork,
            )
        }
    }

    private fun update(
        id: Int,
        title: String,
        description: String,
        recruitingStatus: String,
        projectStatus: String,
        applicationsDeadline: String,
        plannedStartOfWork: String,
        plannedFinishOfWork: String,
    ) {
        viewModelScope.launch {
            val result = repository.updateProject(
                Project(
                    id,
                    "",
                    "",
                    title,
                    description,
                    -1,
                    -1,
                    recruitingStatus,
                    projectStatus,
                    applicationsDeadline,
                    plannedStartOfWork,
                    plannedFinishOfWork,
                )
            )
            if (result.isSuccess) {
                _updated.postValue(true)
                _message.postValue("Project updated successfully")
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
    private fun add(
        title: String,
        description: String,
        maxNumberOfStudents: Int,
        recruitingStatus: String,
        projectStatus: String,
        applicationsDeadline: String,
        plannedStartOfWork: String,
        plannedFinishOfWork: String,
    ) {
        viewModelScope.launch {
            val result = repository.addProject(
                CreateProjectInfo(
                    title,
                    description,
                    maxNumberOfStudents,
                    recruitingStatus,
                    projectStatus,
                    applicationsDeadline,
                    plannedStartOfWork,
                    plannedFinishOfWork,
                )
            )
            if (result.isSuccess) {
                _updated.postValue(true)
                _message.postValue("Project updated successfully")
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }

    fun deleteProject() {
        viewModelScope.launch {
            val result = repository.deleteProject(_id.value!!)
            if (result.isSuccess) {
                _message.postValue("Project deleted successfully")
                _updated.postValue(true)
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}