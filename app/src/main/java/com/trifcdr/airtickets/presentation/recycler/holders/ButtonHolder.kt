package com.trifcdr.airtickets.presentation.recycler.holders

import android.view.View
import androidx.databinding.ViewDataBinding
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.ItemButtonBinding
import com.trifcdr.airtickets.presentation.recycler.itemModels.ButtonItem
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener
import com.trifcdr.airtickets.presentation.recycler.visitor.ViewHolderVisitor

/**
 * Created by trifcdr.
 */
class ButtonHolder : ViewHolderVisitor {

    override val layout: Int = R.layout.item_button
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?,
    ) {
        with(binding as ItemButtonBinding) {
            button = item as ButtonItem
            text.text = item.text
            binding.layout.setOnClickListener {
                clickListener?.onClick(item.id, item.buttonId, item.type)
            }
            if (item.imageId != null) {
                binding.draw.visibility = View.VISIBLE
                binding.draw.setImageResource(item.imageId!!)
            }

        }
    }

    override fun acceptBinding(item: Any): Boolean = item is ButtonItem
}