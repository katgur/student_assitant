package com.example.student_assistant.data.network.mapper

import com.example.student_assistant.data.network.entity.GetUserResponse
import com.example.student_assistant.data.network.entity.LoginRequest
import com.example.student_assistant.data.network.entity.MessageResponse
import com.example.student_assistant.data.network.entity.RegistrationRequest
import com.example.student_assistant.data.network.entity.VerificationRequest
import com.example.student_assistant.domain.entity.LoginInfo
import com.example.student_assistant.domain.entity.RegistrationInfo
import com.example.student_assistant.domain.entity.UserInfo
import com.example.student_assistant.domain.entity.VerificationInfo
import javax.inject.Inject

class AuthMapper @Inject constructor() {

    fun map(info: RegistrationInfo): RegistrationRequest {
        return RegistrationRequest(info.email, info.name, info.surname, info.password)
    }

    fun map(response: MessageResponse): String {
        return response.detail
    }

    fun map(info: VerificationInfo): VerificationRequest {
        return VerificationRequest(info.email, info.code)
    }

    fun map(info: LoginInfo): LoginRequest {
        return LoginRequest(info.email, info.password)
    }

    fun map(response: GetUserResponse): UserInfo {
        return UserInfo(response.isStudent, response.name + " " + response.surname, "Пусто", response.contacts)
    }
}