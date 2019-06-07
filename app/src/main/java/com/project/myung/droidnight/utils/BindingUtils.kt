package com.project.myung.droidnight.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.project.myung.droidnight.main.MainViewModel


object BindingUtils {
    @JvmStatic
    @BindingAdapter("android:onNavigationItemSelected")
    fun setOnNavigationItemSelectedListener(view: BottomNavigationView, viewModel: MainViewModel) {
        view.setOnNavigationItemSelectedListener(viewModel)
    }

    @JvmStatic
    @BindingAdapter("initMap")
    fun initMap(mapView: MapView?, latLng: LatLng) {
        mapView?.apply {
            onCreate(Bundle())
            onResume()

            try {
                MapsInitializer.initialize(mapView.context)
            } catch (e: GooglePlayServicesNotAvailableException) {
                e.printStackTrace()
            }
            getMapAsync { googleMap ->
                googleMap.addMarker(MarkerOptions().position(latLng).title("B1 목동로데오 비바파티룸")).showInfoWindow()
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f))
            }
        }
    }
}