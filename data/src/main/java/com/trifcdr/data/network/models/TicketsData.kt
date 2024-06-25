package com.trifcdr.data.network.models

/**
 * Created by trifcdr.
 */
data class TicketsData(val tickets: List<Ticket>) {
    data class Ticket(
        val id: Long,
        val badge: String? = null,
        val price: Price,
        val provider_name: String,
        val company: String,
        val departure: Departure,
        val arrival: Arrival,
        val has_transfer: Boolean,
        val has_visa_transfer: Boolean,
        val luggage: Luggage,
        val hand_luggage: HandLuggage,
        val is_returnable: Boolean,
        val is_exchangable: Boolean,
    ) {

        data class Price(val value: Int)

        data class Departure(
            val town: String,
            val date: String,
            val airport: String,
        )

        data class Arrival(
            val town: String,
            val date: String,
            val airport: String,
        )

        data class Luggage(
            val has_luggage: Boolean,
            val price: Price,
        )

        data class HandLuggage(
            val has_hand_luggage: Boolean,
            val size: String,
        )
    }
}