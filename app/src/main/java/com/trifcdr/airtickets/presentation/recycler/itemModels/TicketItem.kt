package com.trifcdr.airtickets.presentation.recycler.itemModels

/**
 * Created by trifcdr.
 */
data class TicketItem(
    override val id: String = "ticket",
    val price: Int,
    val badge: String? = null,
    val timeDep: String,
    val timeArr: String,
    val airportDep: String,
    val airportArr: String,
    val timeInTrip: String,
    val hasTransfer: String? = null,
) : StringId