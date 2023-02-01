package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.User

interface IUserRepository {

    suspend fun getUserById(id: Int): User
}