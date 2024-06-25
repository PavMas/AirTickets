package com.trifcdr.data.network

import com.trifcdr.data.Resource
import com.trifcdr.data.network.models.FlightData
import com.trifcdr.data.network.models.ProposalData
import com.trifcdr.data.network.models.TicketsData

/**
 * Created by trifcdr.
 */
interface MockyApi {

    suspend fun getProposals(): Resource<ProposalData>

    suspend fun getFlights(): Resource<FlightData>

    suspend fun getAllTickets(): Resource<TicketsData>
}