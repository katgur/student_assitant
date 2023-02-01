package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.Project

interface IProjectRepository {

    suspend fun getProjectById(id: Int): Project

    suspend fun addProject(project: Project)
}