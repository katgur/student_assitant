package com.example.student_assistant.data.network

import com.example.student_assistant.data.network.entity.LoginRequest
import com.example.student_assistant.data.network.entity.MessageResponse
import com.example.student_assistant.data.network.entity.RegistrationRequest
import com.example.student_assistant.data.network.entity.VerificationRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/register")
    suspend fun register(@Body info: RegistrationRequest)

    @POST("/verify-email")
    suspend fun verifyEmail(@Body info: VerificationRequest)

    @POST("/login")
    suspend fun login(@Body info: LoginRequest)
}