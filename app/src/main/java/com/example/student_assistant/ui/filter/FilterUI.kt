package com.example.student_assistant.ui.filter

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class FilterUI @Inject constructor(private val fragment: FilterFragment) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.filtersIvStatusArrow.setOnClickListener {
            val action = FilterFragmentDirections.actionFiltersFragmentToParametersFragment()
            navController.navigate(action)
        }
        fragment.binding.filtersIvTagsArrow.setOnClickListener {
            val action = FilterFragmentDirections.actionFiltersFragmentToParametersFragment()
            navController.navigate(action)
        }
    }
}