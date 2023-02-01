package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.local.entity.CardDB
import com.example.student_assistant.domain.entity.Card
import javax.inject.Inject

class CardMapper @Inject constructor() {

    fun map(dto: CardDB): Card {
        return Card(dto.id, dto.projectId, dto.creatorId, dto.link)
    }

    fun map(entity: Card): CardDB {
        return CardDB(entity.id, entity.projectId, entity.creatorId, entity.link)
    }
}