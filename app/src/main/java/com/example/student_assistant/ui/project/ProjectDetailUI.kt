package com.example.student_assistant.ui.project

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class ProjectDetailUI @Inject constructor(private val fragment: ProjectDetailFragment) {

    fun load() {
        val id = fragment.arguments?.getInt("id")
        if (id != null) {
            fragment.viewModel.setId(id)
        }
        fragment.binding.detailsEdit.setOnClickListener {
            if (id != null) {
                val action = ProjectDetailFragmentDirections.actionProjectDetailFragmentToProjectEditFragment(id)
                fragment.findNavController().navigate(action)
            }
        }
    }

    fun observe() {
        fragment.viewModel.project.observe(fragment.viewLifecycleOwner) {
            val projectStatus = when (it.projectStatus) {
                "NOT_STARTED" -> "Не начат"
                "IN_PROGRESS" -> "Начат"
                "COMPLETED" -> "Заверешен"
                else -> throw IllegalArgumentException()
            }
            val recStatus = when (it.recruitingStatus) {
                "NOT_STARTED" -> "Не начат"
                "IN_PROGRESS" -> "Начат"
                "COMPLETED" -> "Заверешен"
                else -> throw IllegalArgumentException()
            }
            fragment.binding.apply {
                detailsTvName.setText(it.title)
                detailsTvTime.setText("С ${it.plannedStartOfWork} до ${it.plannedFinishOfWork}")
                detailsTvDescriptionVal.setText(it.description)
                detailsTvCountVal.setText(it.maxNumberOfStudents.toString())
                detailsTvStatusVal.setText(projectStatus)
                detailsTvRecStatusVal.setText(recStatus)
                detailsTvRecDateVal.setText(it.applicationsDeadline)
            }
        }
    }
}