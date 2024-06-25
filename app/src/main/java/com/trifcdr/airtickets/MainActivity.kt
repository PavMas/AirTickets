package com.trifcdr.airtickets

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trifcdr.airtickets.databinding.ActivityMainBinding
import com.trifcdr.airtickets.presentation.fragments.tickets.TicketsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavigation: BottomNavigationView

    private val vm: TicketsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigation = binding.bottomNavigationView
        val navController = this.findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.setupWithNavController(navController)
    }

}