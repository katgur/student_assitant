package com.example.student_assistant.data.network.mapper

import com.example.student_assistant.data.network.entity.AddProjectRequest
import com.example.student_assistant.data.network.entity.AddProjectResponse
import com.example.student_assistant.data.network.entity.GetProjectResponse
import com.example.student_assistant.data.network.entity.GetProjectsByEmailResponse
import com.example.student_assistant.data.network.entity.SearchProjectsRequest
import com.example.student_assistant.data.network.entity.UpdateProjectRequest
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.CreateProjectInfo
import com.example.student_assistant.domain.entity.Project
import javax.inject.Inject

class ProjectMapper @Inject constructor() {
    fun map(info: CreateProjectInfo, email: String): AddProjectRequest {
        return AddProjectRequest(
            email,
            info.title,
            info.description,
            info.maxNumberOfStudents,
            info.recruitingStatus,
            info.projectStatus,
            info.applicationsDeadline,
            info.plannedStartOfWork,
            info.plannedFinishOfWork,
        )
    }

    fun map(response: AddProjectResponse): Int {
        return response.id
    }

    fun map(project: Project): UpdateProjectRequest {
        return UpdateProjectRequest(
            project.id,
            project.title,
            project.description,
            project.recruitingStatus,
            project.projectStatus,
            project.applicationsDeadline,
            project.plannedStartOfWork,
            project.plannedFinishOfWork,
        )
    }

    fun map(response: GetProjectResponse, id: Int): Project {
        return Project(
            id,
            response.authorEmail,
            response.author,
            response.title,
            response.description,
            response.maxNumberOfStudents,
            response.currentNumberOfStudents,
            response.recruitingStatus,
            response.projectStatus,
            response.applicationsDeadline,
            response.plannedStartOfWork,
            response.plannedFinishOfWork,
        )
    }

    fun map(response: GetProjectsByEmailResponse): List<Card> {
        return response.projects.map { Card(it.id, it.title, it.description, it.status ) }
    }
}