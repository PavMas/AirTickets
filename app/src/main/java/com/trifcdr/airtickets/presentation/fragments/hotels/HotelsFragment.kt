package com.trifcdr.airtickets.presentation.fragments.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.airtickets.databinding.FragmentHotelsBinding

/**
 * Created by trifcdr.
 */
class HotelsFragment : Fragment() {

    private lateinit var binding: FragmentHotelsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHotelsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}