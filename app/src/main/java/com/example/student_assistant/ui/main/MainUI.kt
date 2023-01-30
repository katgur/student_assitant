package com.example.student_assistant.ui.main

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class MainUI @Inject constructor(private val fragment: MainFragment) {
    
    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.mainIbFilter.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFiltersFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIbPlus.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProjectEditFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIvAvatar.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIvEdit.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileEditFragment()
            navController.navigate(action)
        }
    }
}