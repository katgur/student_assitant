package com.example.student_assistant.ui.parameter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.student_assistant.domain.entity.Parameter
import javax.inject.Inject

class ParameterDiffCalculator @Inject constructor() : DiffUtil.ItemCallback<Parameter>() {
    override fun areItemsTheSame(oldItem: Parameter, newItem: Parameter): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Parameter, newItem: Parameter): Boolean {
        return oldItem == newItem
    }
}