package com.example.student_assistant.domain.repository

import com.example.student_assistant.domain.entity.Project

interface IProjectRepository {

    fun getProjectById(id: Int): Project
}