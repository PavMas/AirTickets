package com.trifcdr.airtickets.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.trifcdr.airtickets.R
import com.trifcdr.airtickets.databinding.DialogArrivalBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by trifcdr.
 */

@AndroidEntryPoint
class ArrivalDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogArrivalBinding


    private val args: ArrivalDialogArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DialogArrivalBinding.bind(inflater.inflate(R.layout.dialog_arrival, container))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etFromDialog.setText(args.from)
        binding.layoutStambul.setOnClickListener {
            val from = binding.etFromDialog.text.toString()
            if (from != "") {
                val action = ArrivalDialogDirections.actionArrivalDialogToSearchFlights(
                    resources.getString(R.string.stambul),
                    from
                )
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(action)

            }
        }
        binding.layoutSochi.setOnClickListener {
            val from = binding.etFromDialog.text.toString()
            if (from != "") {
                val action = ArrivalDialogDirections.actionArrivalDialogToSearchFlights(
                    resources.getString(R.string.sochi),
                    from
                )
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(action)

            }
        }
        binding.layoutPhuket.setOnClickListener {
            val from = binding.etFromDialog.text.toString()
            if (from != "") {
                val action = ArrivalDialogDirections.actionArrivalDialogToSearchFlights(
                    resources.getString(R.string.phiket),
                    from
                )
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(action)

            }
        }

        binding.difficultTrip.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_arrivalDialog_to_difficultFragment)
        }
        binding.anywhere.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_arrivalDialog_to_anywhereFragment)
        }
        binding.weekends.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_arrivalDialog_to_weekendsFragment)
        }
        binding.hotTickets.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_arrivalDialog_to_hotTicketsFragment)
        }

        binding.cancelWhere.setOnClickListener {
            binding.etWhereDialog.setText("")
        }
    }
}