package com.example.student_assistant.ui.main

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.ui.main.adapter.CardAdapter
import javax.inject.Inject

class MainUI @Inject constructor(private val fragment: MainFragment,
                                 private val adapter: CardAdapter) {
    
    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.mainIbFilter.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFiltersFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIbPlus.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProjectEditFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIvAvatar.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
            navController.navigate(action)
        }
        fragment.binding.mainIvEdit.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProfileEditFragment()
            navController.navigate(action)
        }
        adapter.onItemClick = {
            val action = MainFragmentDirections.actionMainFragmentToProjectDetailFragment(it.first.id)
            navController.navigate(action)
        }
    }

    fun setupHandlers() {
        fragment.binding.apply {
            mainRv.adapter = adapter
            mainRv.layoutManager = LinearLayoutManager(fragment.requireContext())
        }
    }

    fun observeViewModel() {
        fragment.viewModel.apply {
            cards.observe(fragment.viewLifecycleOwner) { items -> adapter.submitList(items) }
        }
    }
}