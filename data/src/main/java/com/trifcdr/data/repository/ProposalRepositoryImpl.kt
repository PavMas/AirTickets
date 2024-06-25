package com.trifcdr.data.repository

import com.trifcdr.data.mappers.mapProposalsToDomain
import com.trifcdr.data.network.MockyApi
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Proposal
import com.trifcdr.domain.repositories.ProposalsRepository

/**
 * Created by trifcdr.
 */
class ProposalRepositoryImpl(
    private val mockyApi: MockyApi,
) : ProposalsRepository {
    override suspend fun getProposals(): DomainResource<List<Proposal>> {
        return mapProposalsToDomain(mockyApi.getProposals())
    }

}