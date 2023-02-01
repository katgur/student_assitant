package com.example.student_assistant.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project
import javax.inject.Inject

class CardDiffCalculator @Inject constructor() : DiffUtil.ItemCallback<Pair<Card, Project>>() {
    override fun areItemsTheSame(
        oldItem: Pair<Card, Project>,
        newItem: Pair<Card, Project>
    ): Boolean {
        return oldItem.first.id == newItem.first.id
    }

    override fun areContentsTheSame(
        oldItem: Pair<Card, Project>,
        newItem: Pair<Card, Project>
    ): Boolean {
        return oldItem.first == newItem.first && oldItem.second == newItem.second
    }
}