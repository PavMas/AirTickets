package com.trifcdr.airtickets.presentation.fragments.weekends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.trifcdr.airtickets.databinding.FragmentWeekendsBinding

/**
 * Created by trifcdr.
 */
class WeekendsFragment : Fragment() {

    private lateinit var binding: FragmentWeekendsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentWeekendsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            val action = WeekendsFragmentDirections.actionWeekendsFragmentToArrivalDialog("")
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}