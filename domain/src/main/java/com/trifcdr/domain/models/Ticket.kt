package com.trifcdr.domain.models

/**
 * Created by trifcdr.
 */
data class Ticket(
    val badge: String? = null,
    val price: Int,
    val departureTime: String,
    val departureAirport: String,
    val arrivalTime: String,
    val arrivalAirport: String,
    val hasTransfer: Boolean,
)