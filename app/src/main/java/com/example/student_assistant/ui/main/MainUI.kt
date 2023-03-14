package com.example.student_assistant.ui.main

import android.animation.ValueAnimator
import android.app.SearchManager
import android.content.Context
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.ui.main.adapter.CardAdapter
import com.example.student_assistant.util.EnumUtil
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import javax.inject.Inject


class MainUI @Inject constructor(
    private val fragment: MainFragment,
    private val adapter: CardAdapter
) {

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
            val action =
                MainFragmentDirections.actionMainFragmentToProjectDetailFragment(it.first.id)
            navController.navigate(action)
        }
    }

    fun setupAdapter() {
        fragment.binding.apply {
            mainRv.adapter = adapter
            mainRv.layoutManager = LinearLayoutManager(fragment.requireContext())
        }
    }

    fun setupHandlers() {
        fragment.binding.apply {
            val searchManager = fragment.requireContext().getSystemService(Context.SEARCH_SERVICE) as SearchManager
            mainEtSearch.setSearchableInfo(searchManager.getSearchableInfo(fragment.requireActivity().componentName))
            mainEtSearch.setOnSearchClickListener {
                mainIvEdit.visibility = View.GONE
                mainIvAvatar.visibility = View.GONE
                mainRgTabs.visibility = View.GONE
                mainIbPlus.visibility = View.GONE
                mainRgTabs.visibility = View.GONE
            }
        }
    }

    fun filter(query: String) {
        fragment.viewModel.setQuery(query)
    }

    fun observeViewModel() {
        fragment.viewModel.apply {
            cards.observe(fragment.viewLifecycleOwner) { items -> adapter.submitList(items) }
        }
        EnumUtil.query.observe(fragment.viewLifecycleOwner) { filter(it) }
    }
}