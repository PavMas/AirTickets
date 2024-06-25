package com.trifcdr.airtickets.presentation.recycler.holders

import androidx.databinding.ViewDataBinding
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.ItemProposalBinding
import com.trifcdr.airtickets.presentation.recycler.itemModels.ProposalItem
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener
import com.trifcdr.airtickets.presentation.recycler.visitor.ViewHolderVisitor

/**
 * Created by trifcdr.
 */
class ProposalHolder : ViewHolderVisitor {

    override val layout: Int = R.layout.item_proposal
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?,
    ) {
        with(binding as ItemProposalBinding) {
            proposal = item as ProposalItem
            label.text = item.label
            town.text = item.town
            value.text = buildString {
                append("от ")
                append(item.value)
            }
            when (item.photoId) {
                1 -> {
                    proposalPhoto.setImageResource(R.drawable.id1)
                }

                2 -> {
                    proposalPhoto.setImageResource(R.drawable.id2)
                }

                3 -> {
                    proposalPhoto.setImageResource(R.drawable.id3)
                }
            }
        }
    }

    override fun acceptBinding(item: Any): Boolean = item is ProposalItem
}