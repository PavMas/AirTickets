package com.trifcdr.data.network.models

/**
 * Created by trifcdr.
 */
data class FlightData(val tickets_offers: List<Data>) {
    data class Data(
        val id: Long,
        val title: String,
        val time_range: Array<String>,
        val price: Price,
    ) {
        data class Price(val value: Int)
    }
}