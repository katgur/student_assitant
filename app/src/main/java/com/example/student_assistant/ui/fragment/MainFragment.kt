package com.example.student_assistant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainIbFilter.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFiltersFragment()
            findNavController().navigate(action)
        }
        binding.mainIbPlus.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProjectEditFragment()
            findNavController().navigate(action)
        }
        binding.mainIvAvatar.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            findNavController().navigate(action)
        }
        binding.mainIvEdit.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileEditFragment()
            findNavController().navigate(action)
        }
    }
}