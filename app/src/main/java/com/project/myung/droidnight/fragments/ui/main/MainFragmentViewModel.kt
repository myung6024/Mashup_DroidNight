package com.project.myung.droidnight.fragments.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

class MainFragmentViewModel : ViewModel() {
    //비바파티룸 좌표
    var mMapLatLng = ObservableField<LatLng>(LatLng(37.527517, 126.860778))
}
