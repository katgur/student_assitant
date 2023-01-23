package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.Card

interface ICardRepository {

    fun getAll(): List<Card>
}