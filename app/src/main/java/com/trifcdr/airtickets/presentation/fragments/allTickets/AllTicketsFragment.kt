package com.trifcdr.airtickets.presentation.fragments.allTickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.FragmentTicketsBinding
import com.trifcdr.airtickets.presentation.recycler.BaseRecyclerAdapter
import com.trifcdr.airtickets.presentation.recycler.itemModels.StringId
import com.trifcdr.airtickets.presentation.recycler.itemModels.TicketItem
import com.trifcdr.airtickets.presentation.recycler.managers.ViewHoldersManager
import com.trifcdr.domain.models.DomainResource
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@AndroidEntryPoint
class AllTicketsFragment : Fragment() {

    private lateinit var binding: FragmentTicketsBinding
    private val vm: AllTicketsViewModel by viewModels()

    private val args: AllTicketsFragmentArgs by navArgs()

    private val itemsTickets = mutableListOf<StringId>()

    private lateinit var ticketItemsAdapter: BaseRecyclerAdapter

    @Inject
    lateinit var viewHoldersManager: ViewHoldersManager
    private lateinit var recyclerTickets: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTicketsBinding.inflate(layoutInflater, container, false)
        recyclerTickets = binding.ticketsRv
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ticketItemsAdapter = BaseRecyclerAdapter(viewHoldersManager)

        recyclerTickets.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ticketItemsAdapter
        }
        vm.getTickets()

        vm.resultTickets.observe(viewLifecycleOwner) { flightResult ->
            ticketItemsAdapter.submitList(null)
            itemsTickets.clear()
            if (flightResult is DomainResource.Success) {
                val res = flightResult.result
                res.forEach {
                    val dateFormatter: DateTimeFormatter =
                        DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss]")
                    val from = LocalDateTime.parse(it.departureTime, dateFormatter)
                    val to = LocalDateTime.parse(it.arrivalTime, dateFormatter)
                    val period = Duration.between(from, to)
                    var min = period.toMinutes()
                    var timeInTrip = ""
                    if (min >= 1440) {
                        timeInTrip += (min / 1440).toString() + "д. "
                        min -= min.div(1440) * 1440
                    }
                    if (min >= 60) {
                        timeInTrip += (min.div(60)).toString() + "ч. "
                        min -= min.div(60) * 60
                    }
                    if (min != 0L) {
                        timeInTrip += min.toString() + "мин."
                    }
                    var transfer: String? = null
                    if (it.hasTransfer) {
                        transfer = resources.getString(R.string.has_ho_transfer)
                    }

                    itemsTickets.add(
                        TicketItem(
                            price = it.price,
                            badge = it.badge,
                            timeDep = String.format("%02d", from.hour) + ":" + String.format(
                                "%02d",
                                from.minute
                            ),
                            timeArr = String.format("%02d", to.hour) + ":" + String.format(
                                "%02d",
                                to.minute
                            ),
                            airportDep = it.departureAirport,
                            airportArr = it.arrivalAirport,
                            hasTransfer = transfer,
                            timeInTrip = timeInTrip
                        )
                    )
                }
                ticketItemsAdapter.submitList(itemsTickets)
            }

            binding.trip.text = buildString {
                append(args.from)
                append(" - ")
                append(args.where)
            }

            binding.tripInfo.text = buildString {
                append(args.date)
                append(" ")
                append(args.passengers)
                append(" пасс.")
            }

            binding.back.setOnClickListener {
                val action = AllTicketsFragmentDirections.actionAllTicketsFragmentToSearchFlights(
                    args.where,
                    args.from
                )
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }
}