package com.example.student_assistant.ui.filter

import androidx.navigation.fragment.findNavController
import com.example.student_assistant.ui.parameter.adapter.ParameterAdapter
import javax.inject.Inject

class FilterUI @Inject constructor(private val fragment: FiltersFragment,
                                   private val adapter: ParameterAdapter) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.filtersIvStatusArrow.setOnClickListener {
            val action = FiltersFragmentDirections.actionFiltersFragmentToParametersFragment()
            navController.navigate(action)
        }
        fragment.binding.filtersIvTagsArrow.setOnClickListener {
            val action = FiltersFragmentDirections.actionFiltersFragmentToParametersFragment()
            navController.navigate(action)
        }
    }
}