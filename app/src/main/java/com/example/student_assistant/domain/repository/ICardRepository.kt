package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project

interface ICardRepository {

    suspend fun getAll(): List<Card>

    suspend fun addCard(card: Card)

    suspend fun getCardById(id: String): Card

    suspend fun filterByNameAndDescription(name: String, description: String): List<Card>
}