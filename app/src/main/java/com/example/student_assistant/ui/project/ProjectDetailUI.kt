package com.example.student_assistant.ui.project

import javax.inject.Inject

class ProjectDetailUI @Inject constructor(private val fragment: ProjectDetailFragment) {

    fun load() {
        val id = fragment.arguments?.getString("id")
        fragment.viewModel.load(id)
    }

    fun observe() {
        fragment.viewModel.project.observe(fragment.viewLifecycleOwner) {
            fragment.binding.detailsTvName.text = it.name
            fragment.binding.detailsTvDescriptionVal.text = it.description
            fragment.binding.detailsTvCountVal.text = it.studentNumber.toString()
            fragment.binding.detailsTvTime.text = "С ${it.startDate} до ${it.endDate}"
        }
    }
}