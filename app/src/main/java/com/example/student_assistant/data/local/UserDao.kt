package com.example.student_assistant.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.student_assistant.data.entity.UserDB

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Int): UserDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserDB)
}