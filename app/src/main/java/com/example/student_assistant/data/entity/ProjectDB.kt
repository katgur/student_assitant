package com.example.student_assistant.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
data class ProjectDB(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    @ColumnInfo(name = "start_date") val startDate: Long,
    @ColumnInfo(name = "end_date") val endDate: Long,
    @ColumnInfo(name = "student_number") val studentNumber: Int,
    @ColumnInfo(name = "due_date") val dueDate: Long,
    val status: Int,
    @ColumnInfo(name = "is_recommended") val isRecommended: Boolean
)
