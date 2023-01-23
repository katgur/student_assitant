package com.example.student_assistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.databinding.FragmentProfileEditBinding
import com.example.student_assistant.databinding.FragmentProjectEditBinding

class ProjectEditFragment : Fragment() {

    private lateinit var binding : FragmentProjectEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProjectEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivClose.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.ivTagsArrow.setOnClickListener {
            val action = ProjectEditFragmentDirections.actionProjectEditFragmentToParametersFragment()
            findNavController().navigate(action)
        }

        binding.ivStatusArrow.setOnClickListener {
            val action = ProjectEditFragmentDirections.actionProjectEditFragmentToParametersFragment()
            findNavController().navigate(action)
        }
    }
}