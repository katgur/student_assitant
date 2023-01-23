package com.example.student_assistant.domain.entity

data class Card(
    val id: Int,
    val projectId: Int,
    val creatorId: Int,
    val link: String
)
