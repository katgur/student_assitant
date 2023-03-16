package com.example.student_assistant.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.UserInfo
import com.example.student_assistant.domain.repository.IUserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val userRepository: IUserRepository,
) : ViewModel() {

    private val _user = MutableLiveData<UserInfo>()
    val user: LiveData<UserInfo> = _user
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun loadUser() {
        viewModelScope.launch {
            val result = userRepository.getUser()
            if (result.isSuccess) {
                _user.postValue(result.getOrNull())
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}