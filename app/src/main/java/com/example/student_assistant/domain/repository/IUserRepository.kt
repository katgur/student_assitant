package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.LoginInfo
import com.example.student_assistant.domain.entity.RegistrationInfo
import com.example.student_assistant.domain.entity.User
import com.example.student_assistant.domain.entity.VerificationInfo

interface IUserRepository {
    suspend fun getUserById(id: Int): User
    suspend fun register(info: RegistrationInfo): Result<Unit>
    suspend fun verify(info: VerificationInfo): Result<Unit>
    suspend fun login(info: LoginInfo): Result<Unit>
}