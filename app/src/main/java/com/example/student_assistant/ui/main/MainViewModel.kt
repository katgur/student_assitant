package com.example.student_assistant.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.student_assistant.R
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.IProjectRepository
import com.example.student_assistant.domain.repository.IUserRepository
import com.example.student_assistant.ui.BaseViewModel

class MainViewModel(
    private val projectRepository: IProjectRepository,
    private val userRepository: IUserRepository,
) : BaseViewModel() {

    private val _isAuthorized = MutableLiveData<Boolean>()
    val isAuthorized: LiveData<Boolean> = _isAuthorized
    private val _cards = MutableLiveData<List<Card>>(emptyList())
    val cards: LiveData<List<Card>> = _cards
    private val _page = MutableLiveData(R.id.rb_all)
    val page: LiveData<Int> = _page

    fun checkIfAuthorized() {
        suspendableLaunch {
            val result = userRepository.getCachedUser()
            _isAuthorized.postValue(result.isSuccess)
        }
    }

    fun setPage(value: Int) {
        _page.value = value
        suspendableLaunch {
            val result = if (value == R.id.rb_all) {
                projectRepository.getProjects()
            } else if (value == R.id.rb_rec) {
                projectRepository.getRecommendedProjects()
            } else {
                Result.failure(IllegalStateException())
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