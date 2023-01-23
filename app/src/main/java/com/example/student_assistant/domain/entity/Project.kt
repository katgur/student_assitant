package com.example.student_assistant.domain.entity

data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val startDate: Long,
    val endDate: Long,
    val studentNumber: Int,
    val dueDate: Long,
    val status: Int
)
