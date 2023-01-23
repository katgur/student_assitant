package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.CardDao
import com.example.student_assistant.data.mapper.CardMapper
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.ICardRepository

class CardRepository(private val dao: CardDao, private val mapper: CardMapper) : ICardRepository {

    override fun getAll(): List<Card> {
        return dao.getAll().map { mapper.map(it) }
    }
}