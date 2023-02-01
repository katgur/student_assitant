package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.Card

interface ICardRepository {

    suspend fun getAll(): List<Card>

    suspend fun addCard(card: Card)
}