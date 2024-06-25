package com.trifcdr.airtickets.presentation.fragments.allTickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Ticket
import com.trifcdr.domain.usecase.GetAllTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@HiltViewModel
class AllTicketsViewModel @Inject constructor(
    private val getAllTicketsUseCase: GetAllTicketsUseCase,
) : ViewModel() {


    private var resultTicketsMutable = MutableLiveData<DomainResource<List<Ticket>>>()
    val resultTickets: LiveData<DomainResource<List<Ticket>>>
        get() = resultTicketsMutable


    fun getTickets() = viewModelScope.launch {
        var res: DomainResource<List<Ticket>> = DomainResource.Empty
        CoroutineScope(Dispatchers.IO).launch {
            res = getAllTicketsUseCase.execute()
        }.join()
        resultTicketsMutable.value = res
    }


}