package com.trifcdr.airtickets.presentation.fragments.subscribes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.airtickets.databinding.FragmentSubscribesBinding

/**
 * Created by trifcdr.
 */
class SubscribeFragment : Fragment() {


    private lateinit var binding: FragmentSubscribesBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSubscribesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}