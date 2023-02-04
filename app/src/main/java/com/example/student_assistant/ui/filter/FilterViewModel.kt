package com.example.student_assistant.ui.filter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.student_assistant.domain.entity.Interest
import com.example.student_assistant.domain.entity.Status

class FilterViewModel : ViewModel() {

    private val _parameters = MutableLiveData<List<String>>()
    val parameters: LiveData<List<String>> = _parameters
    private val _isSwapped = MutableLiveData<Boolean>()
    val isSwapped: LiveData<Boolean> = _isSwapped

    // Todo: load parameters from sources
    private val interests = listOf("Lorem ipsum", "Lorem ipsum dolor", "Lorem", "Lorem ipsum dolor sit")
    private val statuses = listOf("Создан", "Завершен", "Есть вакансии")

    init {
        Log.d("kek", "FilterViewModel init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("kek", "filter viewmodel cleared")
    }

    fun setIsSwapped(isSwapped: Boolean) {
        _isSwapped.value = isSwapped
        if (isSwapped) {
            _parameters.value = interests
        } else {
            _parameters.value = statuses
        }
    }
}