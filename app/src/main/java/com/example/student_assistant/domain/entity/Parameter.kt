package com.example.student_assistant.domain.entity

data class Parameter(
    val name: String,
    val values: List<String>,
    val chosen: MutableList<Int>,
    val page: Int,
)
