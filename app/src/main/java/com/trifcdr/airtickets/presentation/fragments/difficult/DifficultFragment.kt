package com.trifcdr.airtickets.presentation.fragments.difficult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.trifcdr.airtickets.databinding.FragmentDifficultBinding

/**
 * Created by trifcdr.
 */
class DifficultFragment : Fragment() {

    private lateinit var binding: FragmentDifficultBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDifficultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            val action = DifficultFragmentDirections.actionDifficultFragmentToArrivalDialog("")
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}