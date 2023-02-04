package com.example.student_assistant.ui.parameter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.student_assistant.domain.entity.Interest
import javax.inject.Inject

class ParameterDiffCalculator @Inject constructor() : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}