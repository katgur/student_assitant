package com.example.student_assistant.domain

import com.example.student_assistant.domain.entity.RegistrationInfo
import com.example.student_assistant.domain.entity.VerificationInfo
import com.example.student_assistant.domain.repository.IUserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val userRepository: IUserRepository) {

    suspend fun register(info: RegistrationInfo): Result<String> {
        return try {
            Result.success(userRepository.register(info))
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        }
    }

    suspend fun verify(info: VerificationInfo): Result<String> {
        return try {
            Result.success(userRepository.verify(info))
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        }
    }
}