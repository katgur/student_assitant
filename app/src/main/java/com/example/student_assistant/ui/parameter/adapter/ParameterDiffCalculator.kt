package com.example.student_assistant.ui.parameter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.student_assistant.domain.entity.Interest
import javax.inject.Inject

class ParameterDiffCalculator @Inject constructor() : DiffUtil.ItemCallback<Interest>() {
    override fun areItemsTheSame(oldItem: Interest, newItem: Interest): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Interest, newItem: Interest): Boolean {
        return oldItem == newItem
    }
}