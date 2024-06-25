package com.trifcdr.domain.repositories

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Flight

/**
 * Created by trifcdr.
 */
interface FlightsRepository {

    suspend fun getFlights(): DomainResource<List<Flight>>

}