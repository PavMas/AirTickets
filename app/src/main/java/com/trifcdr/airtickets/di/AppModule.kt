package com.trifcdr.airtickets.di

import com.trifcdr.airtickets.presentation.recycler.holders.ButtonHolder
import com.trifcdr.airtickets.presentation.recycler.holders.FlightHolder
import com.trifcdr.airtickets.presentation.recycler.holders.ProposalHolder
import com.trifcdr.airtickets.presentation.recycler.holders.TicketHolder
import com.trifcdr.airtickets.presentation.recycler.itemTypes.ItemTypes
import com.trifcdr.airtickets.presentation.recycler.managers.ViewHoldersManager
import com.trifcdr.airtickets.presentation.recycler.visitor.ViewHoldersManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by trifcdr.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideAdaptersManager(): ViewHoldersManager = ViewHoldersManagerImpl().apply {
        registerViewHolder(ItemTypes.PROPOSAL, ProposalHolder())
        registerViewHolder(ItemTypes.BUTTON, ButtonHolder())
        registerViewHolder(ItemTypes.FLIGHT, FlightHolder())
        registerViewHolder(ItemTypes.TICKET, TicketHolder())
    }

}