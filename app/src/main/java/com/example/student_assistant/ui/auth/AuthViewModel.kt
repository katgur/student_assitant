package com.example.student_assistant.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.LoginInfo
import com.example.student_assistant.domain.repository.IUserRepository
import com.example.student_assistant.ui.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val userRepository: IUserRepository
) : BaseViewModel() {

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    init {
        Log.d("kek", "auth")
    }

    fun checkIfAuthorized() {
        _isLoggedIn.value = false
    }

    fun login(email: String, password: String) {
        suspendableLaunch {
            val result = userRepository.login(LoginInfo(email, password))
            Log.d("kek", "login")
            if (result.isSuccess) {
                Log.d("kek", "login success")
                _message.postValue("You are successfully logged in")
                _isLoggedIn.postValue(true)
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}