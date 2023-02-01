package com.example.student_assistant.data.repository

import com.example.student_assistant.data.local.ProjectDao
import com.example.student_assistant.data.mapper.ProjectMapper
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectRepository @Inject constructor(private val dao: ProjectDao, private val mapper: ProjectMapper) : IProjectRepository {

    override suspend fun getProjectById(id: String): Project {
        return dao.getProjectById(id).run { mapper.map(this) }
    }

    override suspend fun addProject(project: Project) {
        dao.addProject(mapper.map(project))
    }
}