package com.example.student_assistant.ui.parameter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.student_assistant.databinding.ItemFilterBinding
import com.example.student_assistant.domain.entity.Interest
import javax.inject.Inject

class ParameterAdapter @Inject constructor(diffCalculator: ParameterDiffCalculator) : ListAdapter<Interest, ParameterAdapter.ParameterViewHolder>(diffCalculator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParameterAdapter.ParameterViewHolder {
        val binding = ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParameterAdapter.ParameterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ParameterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    class ParameterViewHolder(private val binding: ItemFilterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Interest) {
            binding.itemFilterTvItem.text = item.name
        }
    }
}