package com.example.student_assistant.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.App
import com.example.student_assistant.databinding.FragmentAuthBinding
import com.example.student_assistant.databinding.FragmentFiltersBinding
import com.example.student_assistant.ui.filter.FilterViewModel
import dagger.android.support.AndroidSupportInjection

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null

    val binding get() = _binding!!

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToMainFragment()
            findNavController().navigate(action)
        }

        binding.btnRegister.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToRegistrationFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}