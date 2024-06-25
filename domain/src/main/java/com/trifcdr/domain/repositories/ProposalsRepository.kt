package com.trifcdr.domain.repositories

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Proposal

/**
 * Created by trifcdr.
 */
interface ProposalsRepository {

    suspend fun getProposals(): DomainResource<List<Proposal>>
}