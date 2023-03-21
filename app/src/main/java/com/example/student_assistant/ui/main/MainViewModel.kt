package com.example.student_assistant.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.IProjectRepository
import com.example.student_assistant.domain.repository.IUserRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val projectRepository: IProjectRepository,
    private val userRepository: IUserRepository,
) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>(emptyList())
    val cards: LiveData<List<Card>> = _cards
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message
    private val _isSwapped = MutableLiveData(false)
    val isSwapped: LiveData<Boolean> = _isSwapped

    fun load(isSwapped: Boolean) {
        viewModelScope.launch {
            val result = if (!isSwapped) {
                projectRepository.getProjects()
            } else {
                Result.success(listOf())
            }
            if (result.isSuccess) {
                _cards.postValue(result.getOrNull())
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }

    fun setQuery(query: String) {
        viewModelScope.launch {
            val result = projectRepository.searchProject(query)
            if (result.isSuccess) {
                _cards.postValue(result.getOrNull())
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}