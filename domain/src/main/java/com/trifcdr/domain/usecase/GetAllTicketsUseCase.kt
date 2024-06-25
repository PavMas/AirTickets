package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Ticket
import com.trifcdr.domain.repositories.TicketsRepository

/**
 * Created by trifcdr.
 */
class GetAllTicketsUseCase(
    private val repository: TicketsRepository,
) {

    suspend fun execute(): DomainResource<List<Ticket>> {
        return repository.getAllTickets()
    }
}