package com.example.student_assistant.ui.project

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.R
import com.example.student_assistant.domain.entity.Parameter
import com.example.student_assistant.ui.project.adapter.ProjectParametersAdapter
import javax.inject.Inject

class ProjectEditUI @Inject constructor(
    private val fragment: ProjectEditFragment,
    private val adapter: ProjectParametersAdapter,
) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.apply {
            ivClose.setOnClickListener {
                navController.popBackStack()
            }
        }
    }

    fun setupHandlers() {
        fragment.binding.apply {
            projectEditNumberValue.max = 10
            projectBtnSave.setOnClickListener {
                fragment.viewModel.setProject(
                    fragment.binding.projectEditName.text.toString(),
                    fragment.binding.projectEditDesc.text.toString(),
                    fragment.binding.projectEditNumberValue.progress,
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
                    fragment.requireActivity().finish()
                }
            }
            message.observe(fragment.viewLifecycleOwner) {
                Toast.makeText(fragment.requireContext(), it, Toast.LENGTH_LONG).show()
            }
            parameters.observe(fragment.viewLifecycleOwner) {
                fragment.binding.apply {
                    adapter.submitList(it)
                    adapter.onItemClick = {
                        fragment.findNavController().navigate(ProjectEditFragmentDirections.actionProjectEditFragmentToProjectParameterFragment(it.page))
                    }
                    projectRv.adapter = adapter
                    projectRv.layoutManager = LinearLayoutManager(fragment.requireContext())
                }
            }
        }
    }
}