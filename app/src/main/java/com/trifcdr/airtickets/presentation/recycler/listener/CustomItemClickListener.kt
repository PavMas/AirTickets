package com.trifcdr.airtickets.presentation.recycler.listener

/**
 * Created by trifcdr.
 */
class CustomItemClickListener(
    val clickListener: (itemId: String, buttonId: Int?, buttonType: Int?) -> Unit,
) {
    fun onClick(itemId: String, buttonId: Int? = null, buttonType: Int? = null) =
        clickListener(itemId, buttonId, buttonType)
}