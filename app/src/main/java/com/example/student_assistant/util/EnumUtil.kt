package com.example.student_assistant.util

import com.example.student_assistant.domain.entity.Status

object EnumUtil {
    fun statusToInt(status: Status): Int = status.ordinal

    fun intToStatus(int: Int): Status = Status.values()[int]
}