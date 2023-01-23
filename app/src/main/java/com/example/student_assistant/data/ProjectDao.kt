package com.example.student_assistant.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.student_assistant.data.entity.ProjectDB

@Dao
interface ProjectDao {

    @Query("SELECT * FROM project")
    fun getAllProjects(): List<ProjectDB>

    @Insert
    fun addProject(project: ProjectDB)

    @Query("SELECT * FROM project WHERE id = :id")
    fun getProjectById(id: Int): ProjectDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateProject(project: ProjectDB)

    @Delete
    fun deleteProject(project: ProjectDB)
}