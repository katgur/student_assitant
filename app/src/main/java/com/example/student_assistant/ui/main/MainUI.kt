package com.example.student_assistant.ui.main

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class MainUI @Inject constructor(private val fragment: MainFragment) {
    
    private val binding get() = fragment.binding
    private val viewModel get() = fragment.viewModel
    private val navController get() = fragment.findNavController()

    fun navigate() {
        binding.mainIbFilter.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFiltersFragment()
            navController.navigate(action)
        }
        binding.mainIbPlus.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProjectEditFragment()
            navController.navigate(action)
        }
        binding.mainIvAvatar.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            navController.navigate(action)
        }
        binding.mainIvEdit.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileEditFragment()
            navController.navigate(action)
        }
    }
}