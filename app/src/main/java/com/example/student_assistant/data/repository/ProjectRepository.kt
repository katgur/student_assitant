package com.example.student_assistant.data.repository

import android.util.Log
import com.example.student_assistant.data.local.ProjectDao
import com.example.student_assistant.data.local.UserDao
import com.example.student_assistant.data.local.mapper.UserMapper
import com.example.student_assistant.data.local.mapper.ProjectMapper as LocalProjectMapper
import com.example.student_assistant.data.network.AuthApi
import com.example.student_assistant.data.network.entity.DeleteProjectRequest
import com.example.student_assistant.data.network.entity.SearchProjectsRequest
import com.example.student_assistant.data.network.mapper.ProjectMapper as RemoteProjectMapper
import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.CreateProjectInfo
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val dao: ProjectDao,
    private val userDao: UserDao,
    private val userMapper: UserMapper,
    private val api: AuthApi,
    private val mapper: LocalProjectMapper,
    private val apiMapper: RemoteProjectMapper
) : IProjectRepository {
    override suspend fun addProject(info: CreateProjectInfo): Result<Int> {
        return try {
            val cachedLoginInfo = userMapper.mapToLoginInfo(userDao.getUser()[0])
            val id = apiMapper.map(api.addProject(apiMapper.map(info, cachedLoginInfo.email)))
            Result.success(id)
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        } catch (exc: Exception) {
            exc.printStackTrace()
            Result.failure(exc)
        }
    }

    override suspend fun updateProject(project: Project): Result<Unit> {
        return try {
            api.updateProject(apiMapper.map(project))
            Result.success(Unit)
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        } catch (exc: Exception) {
            exc.printStackTrace()
            Result.failure(exc)
        }
    }

    override suspend fun deleteProject(id: Int): Result<Unit> {
        return try {
            api.deleteProject(id)
            Result.success(Unit)
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        } catch (exc: Exception) {
            exc.printStackTrace()
            Result.failure(exc)
        }
    }

    override suspend fun getProject(id: Int): Result<Project> {
        return try {
            val project = apiMapper.map(api.getProject(id), id)
            Result.success(project)
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        } catch (exc: Exception) {
            exc.printStackTrace()
            Result.failure(exc)
        }
    }

    override suspend fun searchProject(substring: String): Result<List<Card>> {
        return try {
            val request = SearchProjectsRequest(substring, "", "")
            val cards = apiMapper.map(api.searchProjects(request))
            Result.success(cards)
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        } catch (exc: Exception) {
            exc.printStackTrace()
            Result.failure(exc)
        }
    }

    override suspend fun getProjects(): Result<List<Card>> {
        return try {
            val cachedUser = userDao.getUser()
            if (cachedUser.isNotEmpty()) {
                val cachedLoginInfo = userMapper.mapToLoginInfo(cachedUser[0])
                val cards = apiMapper.map(api.getProjectsByEmail(cachedLoginInfo.email))
                Result.success(cards)
            } else {
                Result.failure(IllegalStateException("User is not authorized"))
            }
        } catch (exc: IllegalStateException) {
            Result.failure(exc)
        }
    }
}