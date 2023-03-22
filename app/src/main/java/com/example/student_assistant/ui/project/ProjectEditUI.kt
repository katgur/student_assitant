package com.example.student_assistant.ui.project

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import com.example.student_assistant.R
import javax.inject.Inject

class ProjectEditUI @Inject constructor(private val fragment: ProjectEditFragment) {

    fun navigate() {
        val navController = fragment.findNavController()
        val statuses = arrayOf("Не начат", "В процессе", "Закончен")
        val adapter = ArrayAdapter(fragment.requireActivity(), android.R.layout.simple_spinner_dropdown_item, statuses)
        fragment.binding.apply {
            projectEditNumberValue.max = 10
            projectEditProjectStatusValue.adapter = adapter
            projectEditRecStatusValue.adapter = adapter
            ivClose.setOnClickListener {
                navController.popBackStack()
            }
        }
    }
    
    fun setupHandlers() {
        fragment.binding.apply {
            projectBtnSave.setOnClickListener {
                val projectStatus = when (fragment.binding.projectEditProjectStatusValue.selectedItemId) {
                    0L -> "NOT_STARTED"
                    1L -> "IN_PROGRESS"
                    2L -> "COMPLETED"
                    else -> throw IllegalArgumentException()
                }
                val recStatus = when (fragment.binding.projectEditRecStatusValue.selectedItemId) {
                    0L -> "NOT_STARTED"
                    1L -> "IN_PROGRESS"
                    2L -> "COMPLETED"
                    else -> throw IllegalArgumentException()
                }
                fragment.viewModel.addProject(
                    fragment.binding.projectEditName.text.toString(),
                    fragment.binding.projectEditDesc.text.toString(),
                    fragment.binding.projectEditNumberValue.progress,
                    recStatus,
                    projectStatus,
                    fragment.binding.projectEditRecTo.text.toString(),
                    fragment.binding.projectEditFrom.text.toString(),
                    fragment.binding.projectEditTo.text.toString(),
                )
            }
            projectBtnDelete.setOnClickListener {
                fragment.viewModel.deleteProject()
            }
        }
    }

    fun setupViewModel() {
        fragment.viewModel.apply {
            id.observe(fragment.viewLifecycleOwner) {
                if (it != null && it != -1) {
                    fragment.binding.apply {
                        projectEditNumber.visibility = View.GONE
                        projectEditNumberValue.visibility = View.GONE
                    }
                }
            }
            project.observe(fragment.viewLifecycleOwner) {
                if (it != null) {
                    fragment.binding.apply {
                        projectEditName.setText(it.title)
                        projectEditDesc.setText(it.description)
                        projectEditFrom.setText(it.plannedStartOfWork)
                        projectEditTo.setText(it.plannedFinishOfWork)
                        projectEditRecTo.setText(it.applicationsDeadline)
                    }
                }
            }
            updated.observe(fragment.viewLifecycleOwner) {
                if (it) {
                    fragment.findNavController().popBackStack()
                }
            }
            message.observe(fragment.viewLifecycleOwner) {
                Toast.makeText(fragment.requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }
}