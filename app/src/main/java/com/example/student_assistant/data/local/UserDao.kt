package com.example.student_assistant.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.student_assistant.data.local.entity.UserDB

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getUser(): List<UserDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUser(user: UserDB)
}