package com.rahmadev.hamba.home.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.rahmadev.hamba.core.data.source.local.Prefs
import com.rahmadev.hamba.core.domain.model.prayer.PrayerTimes
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        getCurrentLocation()
        setupView()
    }

    private fun setupView() {

        viewModel.city.observe(viewLifecycleOwner) { city ->
            Prefs.userCity = city
            viewModel.getPrayerTimes(city).observe(viewLifecycleOwner, prayerTimerObserver)
            populateCity(city)
        }

        navigateToHadith()
        navigateToDoa()
        navigateToAdzan()
    }

    private fun populateCity(city: String) {
        binding?.cardSchedule?.apply {
            tvLocation.text = city
        }
    }

    private val prayerTimerObserver = Observer<Result<PrayerTimes>> { result ->
        when (result) {
            is Result.Error -> {}
            is Result.Loading -> {}
            is Result.Success -> {
                populatePrayerTimes(result.data)
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
            when {
                permission[Manifest.permission.ACCESS_FINE_LOCATION] ?: false -> {
                    getCurrentLocation()
                }

                permission[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false -> {
                    getCurrentLocation()
                }

                else -> {
                    showLocationAlert()
                }
            }
        }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    @Suppress("DEPRECATION")
    private fun getCurrentLocation() {
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION) && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
                val latLng = LatLng(location.latitude, location.longitude)
                val geoCoder = Geocoder(requireContext(), Locale.getDefault())
                val currentLocation =
                    geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                val locality = currentLocation?.get(0)?.locality

                Prefs.userCoordinates = latLng
                if (locality != null) {
                    viewModel.city.value = locality
                }
            }
        } else {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private fun showLocationAlert() {
        Toast.makeText(
            context,
            "Silahkan izinkan akses lokasi, untuk melanjutkan",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun populatePrayerTimes(prayerTimes: PrayerTimes) {
        binding?.cardSchedule?.scheduleTime?.apply {
            tvSubuhTime.text = prayerTimes.fajr
            tvDzuhurTime.text = prayerTimes.dhuhr
            tvAsrTime.text = prayerTimes.asr
            tvMaghribTime.text = prayerTimes.maghrib
            tvIsyaTime.text = prayerTimes.isha
        }
    }

    private fun navigateToHadith() {
        binding?.cardHadith?.root?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToHadithFragment()
            findNavController().navigate(action)
        }
    }

    private fun navigateToDoa() {
        binding?.cardDoa?.root?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDoaFragment()
            findNavController().navigate(action)
        }
    }

    private fun navigateToAdzan() {
        binding?.cardAdzan?.root?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAdzanFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}