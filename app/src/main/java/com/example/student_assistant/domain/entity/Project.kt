package com.example.student_assistant.domain.entity

data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val studentNumber: Int,
    val dueDate: String,
    val status: Status,
    val parameters: List<Interest>,
)