package com.trifcdr.airtickets.presentation.recycler.itemModels

/**
 * Created by trifcdr.
 */
data class ButtonItem(
    override val id: String = "button",
    val buttonId: Int,
    val type: Int? = null, //type 0 - callback to calendar; type 1 - callback to other; etc...
    var text: String? = null,
    var imageId: Int? = null,
) : StringId