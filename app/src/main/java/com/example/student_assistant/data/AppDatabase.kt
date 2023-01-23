package com.example.student_assistant.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.student_assistant.data.entity.CardDB
import com.example.student_assistant.data.entity.ProjectDB
import com.example.student_assistant.data.entity.UserDB

@Database(entities = [UserDB::class, ProjectDB::class, CardDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProjectDao(): ProjectDao

    abstract fun getUserDao(): UserDao

    abstract fun getCardDao(): CardDao
}