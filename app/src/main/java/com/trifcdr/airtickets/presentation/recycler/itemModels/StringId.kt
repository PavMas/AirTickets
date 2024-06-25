package com.trifcdr.airtickets.presentation.recycler.itemModels

/**
 * Created by trifcdr.
 */
interface StringId {
    val id: String
    override fun equals(other: Any?): Boolean
}