package com.trifcdr.airtickets.presentation.recycler.itemModels

/**
 * Created by trifcdr.
 */
data class FlightItem(
    override val id: String = "flight",
    val title: String,
    val price: Int,
    val timeRange: Array<String>,
    val colorId: Int,
) : StringId