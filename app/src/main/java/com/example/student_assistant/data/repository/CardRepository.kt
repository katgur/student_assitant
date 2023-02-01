package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.CardDao
import com.example.student_assistant.data.mapper.CardMapper
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.repository.ICardRepository
import javax.inject.Inject

class CardRepository @Inject constructor(private val dao: CardDao, private val mapper: CardMapper) : ICardRepository {

    override suspend fun getAll(): List<Card> {
        return dao.getAll().map { mapper.map(it) }
    }

    override suspend fun addCard(card: Card) {
        return dao.addCard(mapper.map(card))
    }
}