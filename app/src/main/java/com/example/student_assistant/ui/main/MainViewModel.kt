package com.example.student_assistant.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.IProjectRepository
import com.example.student_assistant.domain.repository.IUserRepository
import com.example.student_assistant.ui.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val projectRepository: IProjectRepository,
    private val userRepository: IUserRepository,
) : BaseViewModel() {

    private val _isAuthorized = MutableLiveData<Boolean>()
    val isAuthorized: LiveData<Boolean> = _isAuthorized
    private val _cards = MutableLiveData<List<Card>>(emptyList())
    val cards: LiveData<List<Card>> = _cards
    private val _isSwapped = MutableLiveData(false)
    val isSwapped: LiveData<Boolean> = _isSwapped

    init {
        Log.d("kek", "main")
    }

    fun checkIfAuthorized() {
        suspendableLaunch {
            val result = userRepository.getCachedUser()
            _isAuthorized.postValue(result.isSuccess)
        }
    }

    fun load(isSwapped: Boolean? = _isSwapped.value) {
        suspendableLaunch {
            val result = if (isSwapped != null && !isSwapped) {
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
        suspendableLaunch {
            val result = projectRepository.searchProject(query)
            if (result.isSuccess) {
                _cards.postValue(result.getOrNull())
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}