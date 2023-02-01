package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.UserDao
import com.example.student_assistant.data.mapper.UserMapper
import com.example.student_assistant.domain.entity.User
import com.example.student_assistant.domain.repository.IUserRepository

class UserRepository(private val dao: UserDao, private val mapper: UserMapper) : IUserRepository {

    override suspend fun getUserById(id: Int): User {
        return dao.getUser(id).run { mapper.map(this) }
    }
}