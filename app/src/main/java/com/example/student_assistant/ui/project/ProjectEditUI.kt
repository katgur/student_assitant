package com.example.student_assistant.ui.project

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class ProjectEditUI @Inject constructor(private val fragment: ProjectEditFragment) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.ivClose.setOnClickListener {
            navController.popBackStack()
        }
        fragment.binding.ivTagsArrow.setOnClickListener {
            val action = ProjectEditFragmentDirections.actionProjectEditFragmentToParametersFragment()
            navController.navigate(action)
        }

        fragment.binding.ivStatusArrow.setOnClickListener {
            val action = ProjectEditFragmentDirections.actionProjectEditFragmentToParametersFragment()
            navController.navigate(action)
        }
    }
    
    fun setupHandlers() {
        fragment.binding.projectBtnSave.setOnClickListener {
            fragment.viewModel.addProject()
        }
    }
}