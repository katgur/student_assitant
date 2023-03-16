package com.example.student_assistant.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.LoginInfo
import com.example.student_assistant.domain.repository.IUserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val userRepository: IUserRepository
) : ViewModel() {

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = userRepository.login(LoginInfo(email, password))
            if (result.isSuccess) {
                _message.postValue("You are successfully logged in")
                _isLoggedIn.postValue(true)
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}