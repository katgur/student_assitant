package com.example.student_assistant.data.network.mapper

import com.example.student_assistant.data.network.entity.RegistrationRequest
import com.example.student_assistant.data.network.entity.RegistrationResponse
import com.example.student_assistant.data.network.entity.VerificationRequest
import com.example.student_assistant.data.network.entity.VerificationResponse
import com.example.student_assistant.domain.entity.RegistrationInfo
import com.example.student_assistant.domain.entity.VerificationInfo
import javax.inject.Inject

class AuthMapper @Inject constructor() {

    fun map(info: RegistrationInfo): RegistrationRequest {
        return RegistrationRequest(info.email, info.name, info.surname, info.password)
    }

    fun map(response: RegistrationResponse): String {
        return response.detail
    }

    fun map(info: VerificationInfo): VerificationRequest {
        return VerificationRequest(info.email, info.code)
    }

    fun map(response: VerificationResponse): String {
        return response.detail
    }
}