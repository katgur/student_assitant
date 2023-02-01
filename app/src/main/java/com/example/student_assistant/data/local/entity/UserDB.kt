package com.example.student_assistant.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDB(
    @PrimaryKey val id: String,
    val nickname: String,
    val name: String,
    val bio: String,
    val email: String,
    val interests: List<InterestDB>
)
