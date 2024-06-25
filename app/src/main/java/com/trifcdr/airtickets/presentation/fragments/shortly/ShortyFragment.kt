package com.trifcdr.airtickets.presentation.fragments.shortly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.airtickets.databinding.FragmnetShortlyBinding

/**
 * Created by trifcdr.
 */
class ShortyFragment : Fragment() {

    private lateinit var binding: FragmnetShortlyBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmnetShortlyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}