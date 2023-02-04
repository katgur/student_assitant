package com.example.student_assistant.ui.parameter

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.ui.parameter.adapter.ParameterAdapter
import javax.inject.Inject

class ParameterUI @Inject constructor(private val fragment: ParameterFragment,
                                      private val adapter: ParameterAdapter) {


    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.ivBack.setOnClickListener {
            navController.popBackStack()
        }
    }

    fun setupHandlers() {
        fragment.binding.apply {
            paramRv.adapter = adapter
            paramRv.layoutManager = LinearLayoutManager(fragment.requireContext())
            paramTagsRb.setOnCheckedChangeListener { _, b ->
                fragment.viewModel.setIsSwapped(b)
            }
        }
    }

    fun observeViewModel() {
        fragment.viewModel.apply {
            parameters.observe(fragment.viewLifecycleOwner) { items -> adapter.submitList(items) }
        }
    }
}