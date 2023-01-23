package com.example.student_assistant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDB(
    @PrimaryKey val id: Int,
    val nickname: String,
    val name: String,
    val bio: String,
    val email: String,
    val interests: List<String>
)
