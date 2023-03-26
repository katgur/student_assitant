package com.example.student_assistant.ui.main

import android.app.SearchManager
import android.content.Context
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_assistant.R
import com.example.student_assistant.ui.main.adapter.CardAdapter
import com.example.student_assistant.util.EnumUtil
import javax.inject.Inject


class MainUI @Inject constructor(
    private val fragment: MainFragment,
    private val adapter: CardAdapter,
) {

    fun navigate() {
        val navController = fragment.findNavController()
        fragment.binding.apply {
            mainIbPlus.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToProjectActivity(-1)
                navController.navigate(action)
            }
            mainIvMore.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToProfileActivity()
                navController.navigate(action)
            }
            adapter.onItemClick = {
                val action =
                    MainFragmentDirections.actionMainFragmentToProjectActivity(it.id)
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
                mainAbl.setExpanded(false)
            }
            mainEtSearch.setOnCloseListener {
                mainRgTabs.visibility = View.VISIBLE
                mainIbPlus.visibility = View.VISIBLE
                mainRgTabs.visibility = View.VISIBLE
                mainIvMore.visibility = View.VISIBLE
                mainTitle.visibility = View.VISIBLE
                mainAbl.setExpanded(true)
                fragment.viewModel.setPage(R.id.rb_all)
                return@setOnCloseListener false
            }
            mainRgTabs.setOnCheckedChangeListener { _, i ->
                fragment.viewModel.setPage(i)
            }
            mainIbParam.setOnClickListener {
                fragment.findNavController().navigate(MainFragmentDirections.actionMainFragmentToMainParametersFragment())
            }
        }
    }

    fun observeViewModel() {
        fragment.viewModel.apply {
            isAuthorized.observe(fragment.viewLifecycleOwner) {
                if (!it) {
                    fragment.requireActivity().finish()
                }
            }
            cards.observe(fragment.viewLifecycleOwner) { items -> adapter.submitList(items) }
            page.observe(fragment.viewLifecycleOwner) {
                if (fragment.binding.mainRgTabs.checkedRadioButtonId != it) {
                    fragment.binding.mainRgTabs.check(it)
                }
            }
            isLoading.observe(fragment.viewLifecycleOwner) {
                fragment.binding.mainPb.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
        EnumUtil.query.observe(fragment.viewLifecycleOwner) { fragment.viewModel.setQuery(it) }
    }
}