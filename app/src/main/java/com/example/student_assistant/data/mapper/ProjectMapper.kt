package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.entity.ProjectDB
import com.example.student_assistant.domain.entity.Project
import javax.inject.Inject

class ProjectMapper @Inject constructor() {

    fun map(dto: ProjectDB): Project {
        return Project(dto.id, dto.name, dto.description, dto.startDate, dto.endDate,
        dto.studentNumber, dto.dueDate, dto.status)
    }

    fun map(entity: Project): ProjectDB {
        return ProjectDB(entity.id, entity.name, entity.description, entity.startDate,
        entity.endDate, entity.studentNumber, entity.dueDate, entity.status, false)
    }
}