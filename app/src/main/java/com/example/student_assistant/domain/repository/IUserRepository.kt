package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.User

interface IUserRepository {

    fun getUserById(id: Int): User
}