package com.example.student_assistant.di.module

import com.example.student_assistant.data.repository.CardRepository
import com.example.student_assistant.data.repository.ProjectRepository
import com.example.student_assistant.data.repository.UserRepository
import com.example.student_assistant.di.scope.AppScope
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.domain.repository.IProjectRepository
import com.example.student_assistant.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {

    @Binds
    @AppScope
    abstract fun bindsCardRepository(impl: CardRepository): ICardRepository
}