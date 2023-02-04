package com.example.student_assistant.ui.parameter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.student_assistant.databinding.ItemParameterBinding
import javax.inject.Inject

class ParameterAdapter @Inject constructor(diffCalculator: ParameterDiffCalculator) : ListAdapter<String, ParameterAdapter.ParameterViewHolder>(diffCalculator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParameterAdapter.ParameterViewHolder {
        val binding = ItemParameterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParameterAdapter.ParameterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ParameterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    class ParameterViewHolder(private val binding: ItemParameterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.itemFilterTvItem.text = item
        }
    }
}