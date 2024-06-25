package com.trifcdr.data.network.models

/**
 * Created by trifcdr.
 */
data class ProposalData(val offers: List<Data>) {
    data class Data(
        val id: Long,
        val title: String,
        val town: String,
        val price: Price,
    ) {
        data class Price(val value: Int)

    }
}