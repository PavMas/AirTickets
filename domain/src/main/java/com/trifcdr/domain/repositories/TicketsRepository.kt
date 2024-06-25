package com.trifcdr.domain.repositories

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Ticket

/**
 * Created by trifcdr.
 */
interface TicketsRepository {

    suspend fun getAllTickets(): DomainResource<List<Ticket>>

}