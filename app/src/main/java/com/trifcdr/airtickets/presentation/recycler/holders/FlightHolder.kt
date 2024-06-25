package com.trifcdr.airtickets.presentation.recycler.holders

import androidx.databinding.ViewDataBinding
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.ItemFlightBinding
import com.trifcdr.airtickets.presentation.recycler.itemModels.FlightItem
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener
import com.trifcdr.airtickets.presentation.recycler.visitor.ViewHolderVisitor
import java.text.DecimalFormat

/**
 * Created by trifcdr.
 */
class FlightHolder : ViewHolderVisitor {
    override val layout: Int = R.layout.item_flight
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?,
    ) {
        with(binding as ItemFlightBinding) {
            flight = item as FlightItem
            titleFlight.text = item.title
            val dF = DecimalFormat("#,###")
            priceFlight.text = buildString {
                append(dF.format(item.price))
                append(" ₽")
            }
            rangeFlirht.text = item.timeRange.joinToString(separator = " ")
            when (item.colorId) {
                0 -> {
                    colorFlight.setImageResource(R.drawable.circle_red)
                }

                1 -> {
                    colorFlight.setImageResource(R.drawable.circle_blue)
                }

                2 -> {
                    colorFlight.setImageResource(R.drawable.circle_white)
                }
            }
        }
    }

    override fun acceptBinding(item: Any): Boolean = item is FlightItem
}