package com.rahmadev.hamba.core.data.source.local

import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.pixplicity.easyprefs.library.Prefs

object Prefs {

    private const val PREF_KEY_USER_COORDINATES = "pref_user_coordinates"
    private const val PREF_KEY_USER_CITY = "pref_user_city"

    var userCoordinates: LatLng
        get() = Gson().fromJson(
            Prefs.getString(
                PREF_KEY_USER_COORDINATES,
                Gson().toJson(LatLng(0.0, 0.0))
            ), LatLng::class.java
        )
        set(value) {
            Prefs.putString(PREF_KEY_USER_COORDINATES, Gson().toJson(value))
        }

    var userCity: String
        get() = Prefs.getString(PREF_KEY_USER_CITY, "")
        set(value) {
            Prefs.putString(PREF_KEY_USER_CITY, value)
        }
}