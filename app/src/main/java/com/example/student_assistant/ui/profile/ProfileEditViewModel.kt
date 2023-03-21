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


}