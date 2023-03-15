package com.example.student_assistant.data.network.entity

import com.google.gson.annotations.SerializedName

data class VerificationResponse(
    @SerializedName("detail")
    val detail: String,
)
