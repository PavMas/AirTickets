package com.trifcdr.airtickets.presentation.fragments.hotTickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.trifcdr.airtickets.databinding.FragmentHotTicketsBinding

/**
 * Created by trifcdr.
 */
class HotTicketsFragment : Fragment() {

    private lateinit var binding: FragmentHotTicketsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHotTicketsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            val action = HotTicketsFragmentDirections.actionHotTicketsFragmentToArrivalDialog("")
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}