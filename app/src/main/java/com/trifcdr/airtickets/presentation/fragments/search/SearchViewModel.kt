package com.trifcdr.airtickets.presentation.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.Flight
import com.trifcdr.domain.usecase.GetFlightsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getFlightsUseCase: GetFlightsUseCase,
) : ViewModel() {


    private var resultFlightsMutable = MutableLiveData<DomainResource<List<Flight>>>()
    val resultFlights: LiveData<DomainResource<List<Flight>>>
        get() = resultFlightsMutable


    fun getFlights() = viewModelScope.launch {
        var res: DomainResource<List<Flight>> = DomainResource.Empty
        CoroutineScope(Dispatchers.IO).launch {
            res = getFlightsUseCase.execute()
        }.join()
        resultFlightsMutable.value = res
    }


}