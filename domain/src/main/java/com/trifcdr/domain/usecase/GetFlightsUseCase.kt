package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Flight
import com.trifcdr.domain.repositories.FlightsRepository

/**
 * Created by trifcdr.
 */
class GetFlightsUseCase(
    private val repository: FlightsRepository,
) {

    suspend fun execute(): DomainResource<List<Flight>> {
        return repository.getFlights()
    }
}