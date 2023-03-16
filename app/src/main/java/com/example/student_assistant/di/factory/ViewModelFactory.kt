package com.example.student_assistant.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.student_assistant.data.local.UserDao
import com.example.student_assistant.domain.CardWithProjectUseCase
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.domain.repository.IProjectRepository
import com.example.student_assistant.domain.repository.IUserRepository
import com.example.student_assistant.ui.filter.FilterViewModel
import com.example.student_assistant.ui.fragment.AuthViewModel
import com.example.student_assistant.ui.fragment.RegistrationViewModel
import com.example.student_assistant.ui.main.MainViewModel
import com.example.student_assistant.ui.profile.ProfileViewModel
import com.example.student_assistant.ui.project.ProjectViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val cardRepository: ICardRepository,
    private val projectRepository: IProjectRepository,
    private val userRepository: IUserRepository,
    private val cardWithProjectUseCase: CardWithProjectUseCase,
    ) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java))
            MainViewModel(cardWithProjectUseCase) as T
        else if (modelClass.isAssignableFrom(ProfileViewModel::class.java))
            ProfileViewModel(userRepository) as T
        else if (modelClass.isAssignableFrom(ProjectViewModel::class.java))
            ProjectViewModel(cardRepository, projectRepository) as T
        else if (modelClass.isAssignableFrom(FilterViewModel::class.java))
            FilterViewModel() as T
        else if (modelClass.isAssignableFrom(RegistrationViewModel::class.java))
            RegistrationViewModel(userRepository) as T
        else if (modelClass.isAssignableFrom(AuthViewModel::class.java))
            AuthViewModel(userRepository) as T
        else
            throw IllegalArgumentException("ViewModel $modelClass Not Found")
    }
}