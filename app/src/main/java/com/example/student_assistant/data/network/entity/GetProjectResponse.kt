package com.example.student_assistant.data.network.entity

import com.google.gson.annotations.SerializedName

data class GetProjectResponse(
    @SerializedName("author_email")
    val authorEmail: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("max_number_of_students")
    val maxNumberOfStudents: Int,
    @SerializedName("current_number_of_students")
    val currentNumberOfStudents: Int,
    @SerializedName("recruiting_status")
    val recruitingStatus: String,
    @SerializedName("project_status")
    val projectStatus: String,
    @SerializedName("applications_deadline")
    val applicationsDeadline: String,
    @SerializedName("planned_start_of_work")
    val plannedStartOfWork: String,
    @SerializedName("planned_finish_of_work")
    val plannedFinishOfWork: String,
)