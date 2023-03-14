package com.example.student_assistant.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.student_assistant.domain.entity.Card
import javax.inject.Inject
import com.example.student_assistant.databinding.ItemCardBinding
import com.example.student_assistant.domain.entity.Project

class CardAdapter @Inject constructor(diffCalculator: CardDiffCalculator) : ListAdapter<Pair<Card, Project>, CardAdapter.CardViewHolder>(diffCalculator) {

    var onItemClick: ((Pair<Card, Project>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    class CardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<Card, Project>, onItemClick: ((Pair<Card, Project>) -> Unit)?) {
            binding.iCardTvTitle.text = item.second.name
            binding.iCardTvText.text = item.second.description
            binding.iCardTvTime.text = "До ${item.second.dueDate}"
            binding.root.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}