package com.example.student_assistant.ui.main

import android.animation.ValueAnimator
import android.app.SearchManager
import android.content.Context
import android.view.MenuInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.PopupMenu
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.R
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
        fragment.binding.apply {
            mainIbPlus.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToProjectEditFragment(-1)
                navController.navigate(action)
            }
            mainIvMore.setOnClickListener {
                val popup = PopupMenu(fragment.requireContext(), it)
                val inflater: MenuInflater = popup.menuInflater
                inflater.inflate(R.menu.main_menu, popup.menu)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.mi_profile -> {
                            val action = MainFragmentDirections.actionMainFragmentToProfileFragment()
                            navController.navigate(action)
                            return@setOnMenuItemClickListener true
                        }
                        R.id.mi_settings -> {
                            val action = MainFragmentDirections.actionMainFragmentToProfileEditFragment()
                            navController.navigate(action)
                            return@setOnMenuItemClickListener true
                        }
                        R.id.mi_logout -> {
                            fragment.viewModel.logout()
                            navController.popBackStack()
                            return@setOnMenuItemClickListener true
                        }
                        else -> {
                            return@setOnMenuItemClickListener true
                        }
                    }
                }
                popup.show()
            }
            adapter.onItemClick = {
                val action =
                    MainFragmentDirections.actionMainFragmentToProjectDetailFragment(it.id)
                navController.navigate(action)
            }
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
                mainRgTabs.visibility = View.GONE
                mainIbPlus.visibility = View.GONE
                mainRgTabs.visibility = View.GONE
                mainIvMore.visibility = View.GONE
                mainTitle.visibility = View.GONE
            }
        }
    }

    fun observeViewModel() {
        fragment.viewModel.apply {
            load()
            cards.observe(fragment.viewLifecycleOwner) { items -> adapter.submitList(items) }
        }
        EnumUtil.query.observe(fragment.viewLifecycleOwner) { fragment.viewModel.setQuery(it) }
    }
}