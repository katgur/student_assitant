package com.example.student_assistant.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_assistant.domain.entity.UserInfo
import com.example.student_assistant.domain.repository.IUserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileEditViewModel @Inject constructor(
    private val userRepository: IUserRepository
) : ViewModel() {

    private val _isUpdated = MutableLiveData<Boolean>()
    val isUpdated: LiveData<Boolean> = _isUpdated
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun update(name: String, surname: String, bio: String) {
        viewModelScope.launch {
            val result = userRepository.updateUser(name, surname, bio)
            if (result.isSuccess) {
                _message.postValue("Your profile data is changed successfully")
                _isUpdated.postValue(true)
            } else {
                _message.postValue(result.exceptionOrNull()?.message)
            }
        }
    }
}