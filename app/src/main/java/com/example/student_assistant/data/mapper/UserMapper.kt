package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.local.entity.InterestDB
import com.example.student_assistant.data.local.entity.UserDB
import com.example.student_assistant.domain.entity.Interest
import com.example.student_assistant.domain.entity.User

class UserMapper {

    fun map(dto: UserDB): User {
        return User(
            dto.id,
            dto.nickname,
            dto.name,
            dto.bio,
            dto.email,
            dto.interests.map { Interest(it.id, it.name) }
        )
    }

    fun map(entity: User): UserDB {
        return UserDB(
            entity.id,
            entity.nickname,
            entity.name,
            entity.bio,
            entity.email,
            entity.interests.map { InterestDB(it.id, it.name) }
        )
    }
}