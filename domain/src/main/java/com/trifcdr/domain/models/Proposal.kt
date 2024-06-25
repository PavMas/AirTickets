package com.trifcdr.domain.models

/**
 * Created by trifcdr.
 */
data class Proposal(
    val id: Long,
    val title: String,
    val town: String,
    val price: Int,
)