package com.trifcdr.airtickets.presentation.recycler.itemModels

/**
 * Created by trifcdr.
 */
data class ProposalItem(
    override val id: String = "proposal",
    val label: String? = null,
    val town: String? = null,
    val value: String? = null,
    val photoId: Int? = null,
) : StringId