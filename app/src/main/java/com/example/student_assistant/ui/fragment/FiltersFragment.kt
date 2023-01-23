package com.example.student_assistant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.databinding.FragmentFiltersBinding

class FiltersFragment : Fragment() {

    private lateinit var binding : FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filtersIvStatusArrow.setOnClickListener {
            val action = FiltersFragmentDirections.actionFiltersFragmentToParametersFragment()
            findNavController().navigate(action)
        }

        binding.filtersIvTagsArrow.setOnClickListener {
            val action = FiltersFragmentDirections.actionFiltersFragmentToParametersFragment()
            findNavController().navigate(action)
        }
    }
}