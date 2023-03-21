package com.example.student_assistant.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.UserInfo
import com.example.student_assistant.domain.repository.IUserRepository
import com.example.student_assistant.ui.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val userRepository: IUserRepository,
) : BaseViewModel() {

    private val _user = MutableLiveData<UserInfo>()
    val user: LiveData<UserInfo> = _user
    private val _isUpdated = MutableLiveData<Boolean>()
    val isUpdated: LiveData<Boolean> = _isUpdated

    init {
        Log.d("kek", "profile")
    }
    fun update(name: String, surname: String, bio: String) {
        suspendableLaunch {
            val result = userRepository.updateUser(name, surname, bio)
            if (result.isSuccess) {
                _message.postValue("Your profile data is changed successfully")
                _isUpdated.postValue(true)
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }

    fun loadUser() {
        suspendableLaunch {
            val result = userRepository.getUser()
            if (result.isSuccess) {
                _user.postValue(result.getOrNull())
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }

    fun logout() {
        suspendableLaunch {
            userRepository.logout()
        }
    }
}