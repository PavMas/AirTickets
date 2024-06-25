package com.trifcdr.data.repository

import com.trifcdr.data.mappers.mapTicketsToDomain
import com.trifcdr.data.network.MockyApi
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Ticket
import com.trifcdr.domain.repositories.TicketsRepository

class TicketsRepositoryImpl(
    private val mockyApi: MockyApi,
) : TicketsRepository {
    override suspend fun getAllTickets(): DomainResource<List<Ticket>> {
        return mapTicketsToDomain(mockyApi.getAllTickets())
    }
}