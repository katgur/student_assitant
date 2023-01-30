package com.example.student_assistant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.student_assistant.data.entity.CardDB
import com.example.student_assistant.data.entity.ProjectDB

@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    fun getAll(): List<CardDB>

    @Query("SELECT * FROM card WHERE id = :id")
    fun getCardById(id: Int): CardDB

    @Insert
    fun addCard(card: CardDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateCard(card: CardDB)

    @Delete
    fun deleteCard(card: CardDB)

    @Query("SELECT * FROM " +
            "card JOIN project ON card.project_id = project.id " +
            "WHERE name LIKE :name AND " +
            "description LIKE :description AND start_date < :startDate AND " +
            "end_date > :endDate AND student_number > :minStudentNumber AND " +
            "student_number < :maxStudentNumber AND due_date > :minDueDate AND " +
            "due_date < :maxDueDate AND status == :status")
    fun getCardsByFilter(name: String, description: String, startDate: Long,
                         endDate: Long, minStudentNumber: Int, maxStudentNumber: Int,
                         minDueDate: Long, maxDueDate: Long, status: Int): Map<CardDB, List<ProjectDB>>

    @Query("SELECT * FROM " +
            "card JOIN project ON card.project_id = project.id " +
            "WHERE is_recommended = TRUE")
    fun getRecommendedProjects(): Map<CardDB, List<ProjectDB>>
}