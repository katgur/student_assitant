package com.example.student_assistant.ui.filter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.App
import com.example.student_assistant.databinding.FragmentFiltersBinding
import com.example.student_assistant.databinding.FragmentMainBinding
import com.example.student_assistant.ui.main.MainUI
import com.example.student_assistant.ui.main.MainViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FiltersFragment : Fragment() {

    private var _binding: FragmentFiltersBinding? = null

    val binding get() = _binding!!
    val viewModel: MainViewModel by viewModels {
        (requireContext() as App).getApplicationComponent().viewModelFactory()
    }

    @Inject
    lateinit var ui: FilterUI

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ui.apply {
            navigate()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}