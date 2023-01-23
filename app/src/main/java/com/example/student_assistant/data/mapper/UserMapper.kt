package com.example.student_assistant.data.mapper

import com.example.student_assistant.data.entity.UserDB
import com.example.student_assistant.domain.entity.User

class UserMapper {

    fun map(dto: UserDB): User {
        return User(dto.id, dto.nickname, dto.name, dto.bio, dto.email, dto.interests)
    }

    fun map(entity: User): UserDB {
        return UserDB(entity.id, entity.nickname, entity.name, entity.bio, entity.email, entity.interests)
    }
}