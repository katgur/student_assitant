package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.UserDao
import com.example.student_assistant.data.mapper.UserMapper
import com.example.student_assistant.data.network.AuthApi
import com.example.student_assistant.data.network.mapper.AuthMapper
import com.example.student_assistant.domain.entity.RegistrationInfo
import com.example.student_assistant.domain.entity.User
import com.example.student_assistant.domain.entity.VerificationInfo
import com.example.student_assistant.domain.repository.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dao: UserDao,
    private val api: AuthApi,
    private val mapper: UserMapper,
    private val apiMapper: AuthMapper,
    ) : IUserRepository {

    override suspend fun getUserById(id: Int): User {
        return dao.getUser(id).run { mapper.map(this) }
    }

    override suspend fun register(info: RegistrationInfo): String {
        return apiMapper.map(api.register(apiMapper.map(info)))
    }

    override suspend fun verify(info: VerificationInfo): String {
        return apiMapper.map(api.verifyEmail(apiMapper.map(info)))
    }
}