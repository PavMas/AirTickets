package com.trifcdr.data.repository

import com.trifcdr.data.mappers.mapFlightsToDomain
import com.trifcdr.data.network.MockyApi
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Flight
import com.trifcdr.domain.repositories.FlightsRepository

/**
 * Created by trifcdr.
 */
class FlightsRepositoryImpl(
    private val mockyApi: MockyApi,
) : FlightsRepository {
    override suspend fun getFlights(): DomainResource<List<Flight>> {
        return mapFlightsToDomain(mockyApi.getFlights())
    }
}