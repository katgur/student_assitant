package com.example.student_assistant.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
    }

    @TypeConverter
    fun fromArrayList(list: List<String>): String {
        return Gson().toJson(list)
    }
}