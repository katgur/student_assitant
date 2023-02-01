package com.example.student_assistant.ui.parameter

import androidx.navigation.fragment.findNavController
import com.example.student_assistant.ui.parameter.adapter.ParameterAdapter
import javax.inject.Inject

class ParameterUI @Inject constructor(private val fragment: ParametersFragment,
                                      private val adapter: ParameterAdapter) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.ivBack.setOnClickListener {
            navController.popBackStack()
        }
    }
}