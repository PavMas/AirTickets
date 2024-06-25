package com.trifcdr.data.network

import com.trifcdr.data.Resource
import com.trifcdr.data.network.models.FlightData
import com.trifcdr.data.network.models.ProposalData
import com.trifcdr.data.network.models.TicketsData
import com.trifcdr.data.network.retrofit.MockyApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by trifcdr.
 */
class MockeApiImpl(
    private val api: MockyApiService,
) : MockyApi {

    override suspend fun getProposals(): Resource<ProposalData> {
        var responseFromService: Resource<ProposalData> = Resource.Empty
        val response = api.getProposals()
        CoroutineScope(Dispatchers.IO).launch {
            val proposalResponse = response.execute()
            responseFromService = Resource.Success(proposalResponse.body()!!)
        }.join()
        return responseFromService
    }

    override suspend fun getFlights(): Resource<FlightData> {
        var responseFromService: Resource<FlightData> = Resource.Empty
        val response = api.getFlights()
        CoroutineScope(Dispatchers.IO).launch {
            val flightResponse = response.execute()
            responseFromService = Resource.Success(flightResponse.body()!!)
        }.join()
        return responseFromService
    }

    override suspend fun getAllTickets(): Resource<TicketsData> {
        var responseFromService: Resource<TicketsData> = Resource.Empty
        val response = api.getAllTickets()
        CoroutineScope(Dispatchers.IO).launch {
            val ticketsResponse = response.execute()
            responseFromService = Resource.Success(ticketsResponse.body()!!)
        }.join()
        return responseFromService
    }

}