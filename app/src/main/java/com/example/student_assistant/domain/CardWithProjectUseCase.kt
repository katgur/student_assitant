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
        return withProject(cardRepository.getAll())
    }

    suspend fun add(project: Project, card: Card) {
        projectRepository.addProject(project)
        cardRepository.addCard(card)
    }

    suspend fun byNameAndDescription(subString: String): List<Pair<Card, Project>> {
        return withProject(cardRepository.filterByNameAndDescription(subString, subString))
    }

    private suspend fun withProject(cards: List<Card>): List<Pair<Card, Project>> {
        return cards.map {
            val project = projectRepository.getProjectById(it.projectId)
            return@map Pair(it, project)
        }
    }
}