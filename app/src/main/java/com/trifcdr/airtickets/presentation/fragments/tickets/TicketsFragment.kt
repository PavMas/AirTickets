package com.trifcdr.airtickets.presentation.fragments.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.airtickets.databinding.FragmentFlightsBinding
import com.trifcdr.airtickets.presentation.recycler.BaseRecyclerAdapter
import com.trifcdr.airtickets.presentation.recycler.itemModels.ProposalItem
import com.trifcdr.airtickets.presentation.recycler.itemModels.StringId
import com.trifcdr.airtickets.presentation.recycler.managers.ViewHoldersManager
import com.trifcdr.domain.models.DomainResource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
@AndroidEntryPoint
class TicketsFragment : Fragment() {

    private lateinit var binding: FragmentFlightsBinding
    private val vm: TicketsViewModel by viewModels()

    private val itemsProposal = mutableListOf<StringId>()

    private lateinit var itemsAdapter: BaseRecyclerAdapter


    @Inject
    lateinit var viewHoldersManager: ViewHoldersManager
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFlightsBinding.inflate(inflater, container, false)
        recycler = binding.proposalRecycler
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsAdapter = BaseRecyclerAdapter(viewHoldersManager)
        recycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = itemsAdapter
        }
        vm.getProposals()
        vm.resultProposals.observe(viewLifecycleOwner) { proposalData ->
            if (proposalData is DomainResource.Success) {
                itemsAdapter.submitList(null)
                itemsProposal.clear()
                var photoId = 1
                proposalData.result.forEach {
                    itemsProposal.add(
                        ProposalItem(
                            label = it.title,
                            town = it.town,
                            value = it.price.toString(),
                            photoId = photoId
                        )
                    )
                    photoId++
                }
                itemsAdapter.submitList(itemsProposal)

            }


        }
        binding.etWhere.setOnClickListener {
            val action =
                TicketsFragmentDirections.actionAirTicketsToArrivalDialog(binding.etFrom.text.toString())
            Navigation.findNavController(binding.root).navigate(action)
        }


    }

}