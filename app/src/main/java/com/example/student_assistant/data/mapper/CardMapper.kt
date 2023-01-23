package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.entity.CardDB
import com.example.student_assistant.domain.entity.Card

class CardMapper {

    fun map(dto: CardDB): Card {
        return Card(dto.id, dto.projectId, dto.creatorId, dto.link)
    }

    fun map(entity: Card): CardDB {
        return CardDB(entity.id, entity.projectId, entity.creatorId, entity.link)
    }
}