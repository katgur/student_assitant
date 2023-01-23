package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.ProjectDao
import com.example.student_assistant.data.mapper.ProjectMapper
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.IProjectRepository

class ProjectRepository(private val dao: ProjectDao, private val mapper: ProjectMapper) : IProjectRepository {

    override fun getProjectById(id: Int): Project {
        return dao.getProjectById(id).run { mapper.map(this) }
    }
}