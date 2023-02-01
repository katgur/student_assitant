package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.local.entity.ProjectDB
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.util.DateUtil
import com.example.student_assistant.util.EnumUtil
import javax.inject.Inject

class ProjectMapper @Inject constructor() {

    fun map(dto: ProjectDB): Project {
        return Project(
            dto.id, dto.name, dto.description,
            DateUtil.longToDateString(dto.startDate),
            DateUtil.longToDateString(dto.endDate),
            dto.studentNumber,
            DateUtil.longToDateString(dto.dueDate),
            EnumUtil.intToStatus(dto.status),
            emptyList()
        )
    }

    fun map(entity: Project): ProjectDB {
        return ProjectDB(
            entity.id, entity.name, entity.description,
            DateUtil.stringToLong(entity.startDate),
            DateUtil.stringToLong(entity.endDate),
            entity.studentNumber,
            DateUtil.stringToLong(entity.dueDate),
            EnumUtil.statusToInt(entity.status),
            false
        )
    }
}