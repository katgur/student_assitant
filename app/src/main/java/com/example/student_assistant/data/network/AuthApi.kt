package com.example.student_assistant.data.network

import com.example.student_assistant.data.network.entity.RegistrationRequest
import com.example.student_assistant.data.network.entity.RegistrationResponse
import com.example.student_assistant.data.network.entity.VerificationRequest
import com.example.student_assistant.data.network.entity.VerificationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/register")
    suspend fun register(@Body info: RegistrationRequest): RegistrationResponse

    @POST("/verify-email")
    suspend fun verifyEmail(@Body info: VerificationRequest): VerificationResponse
}