package com.trifcdr.airtickets.presentation.fragments.search

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.FragmentSearchBinding
import com.trifcdr.airtickets.presentation.recycler.BaseRecyclerAdapter
import com.trifcdr.airtickets.presentation.recycler.itemModels.ButtonItem
import com.trifcdr.airtickets.presentation.recycler.itemModels.FlightItem
import com.trifcdr.airtickets.presentation.recycler.itemModels.StringId
import com.trifcdr.airtickets.presentation.recycler.listener.CustomItemClickListener
import com.trifcdr.airtickets.presentation.recycler.managers.ViewHoldersManager
import com.trifcdr.domain.models.DomainResource
import dagger.hilt.android.AndroidEntryPoint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val vm: SearchViewModel by viewModels()

    private val args: SearchFragmentArgs by navArgs()

    private val itemsButtons = mutableListOf<StringId>()
    private val itemsFlights = mutableListOf<StringId>()

    private lateinit var buttonItemsAdapter: BaseRecyclerAdapter
    private lateinit var flightItemsAdapter: BaseRecyclerAdapter


    @Inject
    lateinit var viewHoldersManager: ViewHoldersManager
    private lateinit var recyclerButtons: RecyclerView
    private lateinit var recyclerFlights: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        recyclerButtons = binding.buttonRv
        recyclerFlights = binding.flightsRv
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getFlights()
        binding.etFromSearch.setText(args.from)
        binding.etWhereSearch.setText(args.where)
        val df: DateFormat = SimpleDateFormat("dd, MMM, EE")
        val date = df.format(Calendar.getInstance().time)

        val calendar = Calendar.getInstance()


        itemsButtons.add(ButtonItem(type = 0, text = getString(R.string.plus_back), buttonId = 0))
        itemsButtons.add(ButtonItem(type = 0, text = date, buttonId = 1))
        itemsButtons.add(
            ButtonItem(
                type = 1,
                text = getString(R.string._1),
                imageId = R.drawable.ic_profile,
                buttonId = 2
            )
        )
        itemsButtons.add(
            ButtonItem(
                type = 1,
                text = getString(R.string.filter),
                imageId = R.drawable.ic_filter,
                buttonId = 3
            )
        )

        binding.replaceBtn.setOnClickListener {
            val temp = binding.etFromSearch.text
            binding.etFromSearch.text = binding.etWhereSearch.text
            binding.etWhereSearch.text = temp
        }

        binding.clear.setOnClickListener {
            binding.etWhereSearch.setText("")
        }

        buttonItemsAdapter = BaseRecyclerAdapter(
            viewHoldersManager,
            CustomItemClickListener { itemId, buttonId, buttonType ->
                if (buttonType == 0) {
                    DatePickerDialog(
                        requireActivity(), { _, year, monthOfYear, dayOfMonth ->
                            calendar.set(Calendar.YEAR, year)
                            calendar.set(Calendar.MONTH, monthOfYear)
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                            val element = itemsButtons.removeAt(buttonId!!) as ButtonItem
                            element.text = df.format(calendar.time)
                            itemsButtons.add(buttonId, element)
                            buttonItemsAdapter.submitList(itemsButtons)
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                        .show()
                }
            })
        flightItemsAdapter = BaseRecyclerAdapter(viewHoldersManager)

        recyclerButtons.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = buttonItemsAdapter
        }
        recyclerFlights.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = flightItemsAdapter
        }


        buttonItemsAdapter.submitList(itemsButtons)
        vm.resultFlights.observe(viewLifecycleOwner) { flightData ->
            if (flightData is DomainResource.Success) {
                flightItemsAdapter.submitList(null)
                itemsFlights.clear()
                var colorId = 0
                flightData.result.forEach {
                    itemsFlights.add(
                        FlightItem(
                            title = it.title,
                            price = it.price,
                            timeRange = it.timeRange,
                            colorId = colorId
                        )
                    )
                    colorId++
                }
                flightItemsAdapter.submitList(itemsFlights)

            }
        }

        binding.allTicketsButton.setOnClickListener {
            if (binding.etWhereSearch.text.toString() != "" && binding.etFromSearch.text.toString() != "") {
                val df: DateFormat = SimpleDateFormat("dd MMMM")
                val date = df.format(Calendar.getInstance().time)
                val passengers = itemsButtons[2] as ButtonItem
                val action = SearchFragmentDirections.actionSearchFlightsToAllTicketsFragment(
                    binding.etWhereSearch.text.toString(),
                    binding.etFromSearch.text.toString(),
                    date,
                    passengers.text!!.substring(0, 1)
                )
                Navigation.findNavController(binding.root).navigate(action)
            } else {
                Toast.makeText(requireContext(), getString(R.string.fill_all), Toast.LENGTH_SHORT)
                    .show()
            }

        }


    }
}