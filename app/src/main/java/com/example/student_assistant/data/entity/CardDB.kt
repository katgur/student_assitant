package com.example.student_assistant.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card")
data class CardDB(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "project_id") val projectId: Int,
    @ColumnInfo(name = "creator_id") val creatorId: Int,
    val link: String
)
