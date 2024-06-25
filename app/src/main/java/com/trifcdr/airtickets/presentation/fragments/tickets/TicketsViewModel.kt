package com.trifcdr.airtickets.presentation.fragments.tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Proposal
import com.trifcdr.domain.usecase.GetProposalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@HiltViewModel
class TicketsViewModel @Inject constructor(
    private val getProposalsUseCase: GetProposalsUseCase,
) : ViewModel() {


    private var resultProposalsMutable = MutableLiveData<DomainResource<List<Proposal>>>()
    val resultProposals: LiveData<DomainResource<List<Proposal>>>
        get() = resultProposalsMutable


    fun getProposals() = viewModelScope.launch {
        var res: DomainResource<List<Proposal>> = DomainResource.Empty
        CoroutineScope(Dispatchers.IO).launch {
            res = getProposalsUseCase.execute()
        }.join()
        resultProposalsMutable.value = res
    }

}