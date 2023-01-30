package com.example.student_assistant.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.ui.main.MainViewModel
import com.example.student_assistant.ui.stateholder.ProfileViewModel
import com.example.student_assistant.ui.stateholder.ProjectViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: ICardRepository
    ) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java))
            MainViewModel(repository) as T
        else if (modelClass.isAssignableFrom(ProfileViewModel::class.java))
            ProfileViewModel() as T
        else if (modelClass.isAssignableFrom(ProjectViewModel::class.java))
            ProjectViewModel() as T
        else
            throw IllegalArgumentException("ViewModel $modelClass Not Found")
    }
}