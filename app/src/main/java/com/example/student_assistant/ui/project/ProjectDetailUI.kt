package com.example.student_assistant.ui.project

import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.student_assistant.ui.project.adapter.TagAdapter
import javax.inject.Inject

class ProjectDetailUI @Inject constructor(
    private val fragment: ProjectDetailFragment,
    private val adapter: TagAdapter,
) {

    fun load() {
        val id = fragment.requireActivity().intent.extras?.getInt("id")
        if (id != null) {
            fragment.viewModel.setId(id)
            if (id == -1) {
                fragment.findNavController()
                    .navigate(ProjectDetailFragmentDirections.actionProjectDetailFragmentToProjectEditFragment())
            }
        }
        fragment.binding.apply {
            detailsIvBack.setOnClickListener {
                fragment.requireActivity().finish()
            }
            detailsIvEdit.setOnClickListener {
                if (id != null) {
                    val action =
                        ProjectDetailFragmentDirections.actionProjectDetailFragmentToProjectEditFragment()
                    fragment.findNavController().navigate(action)
                }
            }
            detailsJoin.setOnClickListener {
                fragment.viewModel.join()
            }
        }
    }

    fun setupRecycler() {
        fragment.binding.apply {
            detailsTagRv.adapter = adapter
            detailsTagRv.layoutManager =
                LinearLayoutManager(fragment.requireContext(), RecyclerView.HORIZONTAL, false)
        }
    }

    fun observe() {
        fragment.viewModel.apply {
            project.observe(fragment.viewLifecycleOwner) {
                fragment.binding.apply {
                    detailsTvName.text = it.title
                    detailsTvTime.text = "С ${it.plannedStartOfWork} до ${it.plannedFinishOfWork}"
                    detailsTvDescriptionVal.text = it.description
                    detailsTvAuthorVal.text = it.author
                    detailsTvCurCountVal.text = it.currentNumberOfStudents.toString()
                    detailsTvCountVal.text = it.maxNumberOfStudents.toString()
                    detailsTvStatusVal.text = it.projectStatus
                    detailsTvRecStatusVal.text = it.recruitingStatus
                    detailsTvRecDateVal.text = it.applicationsDeadline
                }
                adapter.submitList(it.tags)
            }
            message.observe(fragment.viewLifecycleOwner) {
                if (it != null) {
                    Toast.makeText(fragment.requireContext(), it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}