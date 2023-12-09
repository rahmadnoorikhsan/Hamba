package com.rahmadev.hamba.presentation.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rahmadev.hamba.R
import com.rahmadev.hamba.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.rahmadev.hamba.compass.R as CompassResource
import com.rahmadev.hamba.home.R as HomeResource
import com.rahmadev.hamba.quran.R as QuranResource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            Handler(Looper.getMainLooper()).post {
                when (navDestination.id) {
                    CompassResource.id.compassFragment, HomeResource.id.homeFragment, QuranResource.id.quranFragment -> {
                        binding.bottomNav.visibility = View.VISIBLE
                    }

                    else -> {
                        binding.bottomNav.visibility = View.GONE
                    }
                }
            }
        }

        binding.bottomNav.setupWithNavController(navController)
    }
}