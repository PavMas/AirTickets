package com.trifcdr.airtickets.presentation.recycler.holders

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.ItemTicketBinding
import com.trifcdr.airtickets.presentation.recycler.itemModels.TicketItem
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener
import com.trifcdr.airtickets.presentation.recycler.visitor.ViewHolderVisitor
import java.text.DecimalFormat

/**
 * Created by trifcdr.
 */
class TicketHolder : ViewHolderVisitor {

    override val layout: Int = R.layout.item_ticket
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?,
    ) {
        with(binding as ItemTicketBinding) {
            ticket = item as TicketItem
            val dF = DecimalFormat("#,###")
            if (item.badge != null) {
                badge.visibility = View.VISIBLE
                badge.text = item.badge
                priceTicket.text = buildString {
                    append(dF.format(item.price))
                    append(" ₽")
                }
            } else {
                val lParam = ticketLayout.layoutParams as ViewGroup.MarginLayoutParams
                lParam.topMargin = 0
                ticketLayout.layoutParams = lParam

                priceTicket.visibility = View.GONE
                priceTicket16.visibility = View.VISIBLE

                priceTicket16.text = buildString {
                    append(dF.format(item.price))
                    append(" ₽")
                }

            }
            arrivalAirportTv.text = item.airportArr
            departmentAirportTv.text = item.airportDep

            arrivalTimeTv.text = item.timeArr
            departmentTimeTv.text = item.timeDep

            timeInTrip.text = item.timeInTrip

            if (item.hasTransfer != null) {
                sep.visibility = View.VISIBLE
                hasTransferTv.text = item.hasTransfer
            }

        }
    }

    override fun acceptBinding(item: Any): Boolean = item is TicketItem
}