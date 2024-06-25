package com.trifcdr.airtickets.di

import com.trifcdr.domain.repositories.FlightsRepository
import com.trifcdr.domain.repositories.ProposalsRepository
import com.trifcdr.domain.repositories.TicketsRepository
import com.trifcdr.domain.usecase.GetAllTicketsUseCase
import com.trifcdr.domain.usecase.GetFlightsUseCase
import com.trifcdr.domain.usecase.GetProposalsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by trifcdr.
 */

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetProposalUseCase(repository: ProposalsRepository): GetProposalsUseCase {
        return GetProposalsUseCase(repository)
    }

    @Provides
    fun provideGetFlightUseCase(repository: FlightsRepository): GetFlightsUseCase {
        return GetFlightsUseCase(repository)
    }

    @Provides
    fun provideGetAllTicketsUseCase(repository: TicketsRepository): GetAllTicketsUseCase {
        return GetAllTicketsUseCase(repository)
    }

}