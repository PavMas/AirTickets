package com.trifcdr.data.mappers

import com.trifcdr.data.Resource
import com.trifcdr.data.network.models.FlightData
import com.trifcdr.data.network.models.ProposalData
import com.trifcdr.data.network.models.TicketsData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Flight
import com.trifcdr.domain.models.Proposal
import com.trifcdr.domain.models.Ticket

/**
 * Created by trifcdr.
 */

fun mapProposalsToDomain(proposalResponseResult: Resource<ProposalData>): DomainResource<List<Proposal>> {

    when (proposalResponseResult) {
        is Resource.Success -> {
            val res = proposalResponseResult.result
            val proposalList = mutableListOf<Proposal>()
            res.offers.forEach {
                proposalList.add(
                    Proposal(
                        id = it.id,
                        title = it.title,
                        town = it.town,
                        price = it.price.value
                    )
                )
            }
            return DomainResource.Success(proposalList)
        }

        is Resource.Failure -> {
            return DomainResource.Failure(proposalResponseResult.exception)
        }

        else -> {
            return DomainResource.Failure(Exception("proposal mapping error"))
        }

    }
}

fun mapFlightsToDomain(flightResponseResult: Resource<FlightData>): DomainResource<List<Flight>> {
    when (flightResponseResult) {
        is Resource.Success -> {
            val res = flightResponseResult.result
            val flightList = mutableListOf<Flight>()
            res.tickets_offers.forEach {
                flightList.add(
                    Flight(
                        title = it.title,
                        timeRange = it.time_range,
                        price = it.price.value
                    )
                )
            }
            return DomainResource.Success(flightList)
        }

        is Resource.Failure -> {
            return DomainResource.Failure(flightResponseResult.exception)
        }

        else -> {
            return DomainResource.Failure(Exception("flight mapping error"))
        }
    }
}

fun mapTicketsToDomain(ticketResponseResult: Resource<TicketsData>): DomainResource<List<Ticket>> {
    when (ticketResponseResult) {
        is Resource.Success -> {
            val res = ticketResponseResult.result
            val tickets = mutableListOf<Ticket>()
            res.tickets.forEach {
                tickets.add(
                    Ticket(
                        badge = it.badge,
                        price = it.price.value,
                        departureTime = it.departure.date,
                        departureAirport = it.departure.airport,
                        arrivalTime = it.arrival.date,
                        arrivalAirport = it.arrival.airport,
                        hasTransfer = it.has_transfer
                    )
                )
            }

            return DomainResource.Success(tickets)
        }

        is Resource.Failure -> {
            return DomainResource.Failure(ticketResponseResult.exception)
        }

        else -> {
            return DomainResource.Failure(Exception("flight mapping error"))
        }
    }
}