package com.example.student_assistant.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.student_assistant.R
import com.example.student_assistant.domain.entity.Card
import javax.inject.Inject
import com.example.student_assistant.databinding.ItemCardBinding
import com.example.student_assistant.domain.entity.Project

class CardAdapter @Inject constructor(diffCalculator: CardDiffCalculator) : ListAdapter<Pair<Card, Project>, CardAdapter.CardViewHolder>(diffCalculator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<Card, Project>) {
            binding.iCardTvTitle.text = item.second.name
            binding.iCardTvText.text = item.second.description
            binding.iCardTvTime.text = "Due to ${item.second.dueDate}"
        }
    }
}