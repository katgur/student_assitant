package com.example.student_assistant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.student_assistant.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private lateinit var binding : FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        binding.btnLogin.setOnClickListener {
//            val action = AuthFragmentDirections.actionAuthFragmentToMainFragment()
//            findNavController().navigate(action)
//        }
    }
}