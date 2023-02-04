package com.example.student_assistant.domain

import com.example.student_assistant.domain.entity.Card
import com.example.student_assistant.domain.entity.Project
import com.example.student_assistant.domain.repository.ICardRepository
import com.example.student_assistant.domain.repository.IProjectRepository
import javax.inject.Inject

class CardWithProjectUseCase @Inject constructor(
    private val cardRepository: ICardRepository,
    private val projectRepository: IProjectRepository,
) {
    suspend fun getAll(): List<Pair<Card, Project>> {
        val cards = cardRepository.getAll()
        return cards.map {
            val project = projectRepository.getProjectById(it.projectId)
            return@map Pair(it, project)
        }
    }

    suspend fun add(project: Project, card: Card) {
        projectRepository.addProject(project)
        cardRepository.addCard(card)
    }
}