package com.trifcdr.airtickets.di

import com.trifcdr.data.network.MockeApiImpl
import com.trifcdr.data.network.MockyApi
import com.trifcdr.data.network.retrofit.MockyApiService
import com.trifcdr.data.repository.FlightsRepositoryImpl
import com.trifcdr.data.repository.ProposalRepositoryImpl
import com.trifcdr.data.repository.TicketsRepositoryImpl
import com.trifcdr.domain.repositories.FlightsRepository
import com.trifcdr.domain.repositories.ProposalsRepository
import com.trifcdr.domain.repositories.TicketsRepository
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
class DataModule {

    private val retrofit = MockyApiService.getInstance()


    @Provides
    @Singleton
    fun provideMockyApiService(): MockyApiService = retrofit

    @Provides
    @Singleton
    fun provideMockyApi(): MockyApi = MockeApiImpl(retrofit)

    @Provides
    @Singleton
    fun provideProposalRepository(
        api: MockyApi,
    ): ProposalsRepository {
        return ProposalRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFlightRepository(
        api: MockyApi,
    ): FlightsRepository {
        return FlightsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideTicketsRepository(
        api: MockyApi,
    ): TicketsRepository {
        return TicketsRepositoryImpl(api)
    }

}
