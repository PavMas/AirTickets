package com.trifcdr.airtickets.presentation.recycler.visitor

import androidx.databinding.ViewDataBinding
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener

/**
 * Created by trifcdr.
 */
interface ViewHolderVisitor {

    val layout: Int

    fun bind(binding: ViewDataBinding, item: Any, clickListener: CustomItemClickListener?)
    fun acceptBinding(item: Any): Boolean
}