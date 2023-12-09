package com.rahmadev.hamba.compass

import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.rahmadev.hamba.compass.databinding.FragmentCompassBinding
import com.rahmadev.hamba.core.data.source.local.Prefs
import com.rahmadev.hamba.core.utils.Compass
import com.rahmadev.hamba.core.utils.SOTWFormatter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

class CompassFragment : Fragment() {

    private var _binding: FragmentCompassBinding? = null
    private val binding get() = _binding
    private var currentAzimuth = 0f
    private lateinit var compass: Compass
    private lateinit var formatter: SOTWFormatter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompassBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCompass()
        formatter = SOTWFormatter(requireActivity())
    }

    private fun setupCompass() {
        compass = Compass(requireActivity())
        val compassListener: Compass.CompassListener = getCompassListener()
        compass.setListener(compassListener)
    }

    private fun adjustArrow(azimuth: Float) {
        val kaabaLng = 39.826206
        val kaabaLat = Math.toRadians(21.422487)
        val myLatRad = Math.toRadians(Prefs.userCoordinates.latitude)
        val longDiff = Math.toRadians(kaabaLng - 107.446274)
        val y = sin(longDiff) * cos(kaabaLat)
        val x = cos(myLatRad) * sin(kaabaLat) - sin(myLatRad) * cos(kaabaLat) * cos(longDiff)
        val result = (Math.toDegrees(atan2(y, x)) + 360) % 360

        binding?.apply {
            tvLocation.text = Prefs.userCity
            ivArrow.rotation = result.toFloat()
            tvSotw.text = formatter.format(azimuth)
        }

        val animation = RotateAnimation(
            -currentAzimuth,
            -azimuth,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        animation.apply {
            duration = 10
            repeatCount = 0
            fillAfter = true
        }

        binding?.viewCompass?.startAnimation(animation)
    }

    private fun getCompassListener(): Compass.CompassListener {
        return object : Compass.CompassListener {
            override fun onNewAzimuth(azimuth: Float) {
                CoroutineScope(Dispatchers.Main).launch {
                    adjustArrow(azimuth)
                }
            }

            override fun onAccuracyChanged(accuracy: Int) {
                when (accuracy) {
                    SensorManager.SENSOR_STATUS_ACCURACY_LOW -> {
                        binding?.viewCompass?.visibility = View.INVISIBLE
                    }

                    SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> {
                        binding?.viewCompass?.visibility = View.INVISIBLE
                    }

                    SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> {
                        binding?.viewCompass?.visibility = View.VISIBLE
                    }
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        compass.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        compass.stop()
    }

    override fun onPause() {
        super.onPause()
        compass.stop()
    }

    override fun onResume() {
        super.onResume()
        compass.start()
    }

    override fun onStop() {
        super.onStop()
        compass.stop()
    }
}