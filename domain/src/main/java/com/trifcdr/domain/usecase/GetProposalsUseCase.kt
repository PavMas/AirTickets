package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Proposal
import com.trifcdr.domain.repositories.ProposalsRepository

/**
 * Created by trifcdr.
 */
class GetProposalsUseCase(
    private val repository: ProposalsRepository,
) {

    suspend fun execute(): DomainResource<List<Proposal>> {
        return repository.getProposals()
    }

}