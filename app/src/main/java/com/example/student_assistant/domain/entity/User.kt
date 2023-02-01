package com.example.student_assistant.domain.entity

data class User(
    val id: String,
    val nickname: String,
    val name: String,
    val bio: String,
    val email: String,
    val interests: List<Interest>
)
