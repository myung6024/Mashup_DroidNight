package com.project.myung.droidnight.main

import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.myung.droidnight.R
import com.project.myung.droidnight.base.BaseViewModel
import com.project.myung.droidnight.fragments.ui.main.MainFragment

class MainViewModel : BaseViewModel(), BottomNavigationView.OnNavigationItemSelectedListener {
    val fragment = MutableLiveData<Fragment>()

    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment.value = MainFragment.newInstance()
                return true
            }
            /*R.id.navigation_dashboard -> {
                fragment.value = MainFragment.newInstance()
                return true
            }
            R.id.navigation_notifications -> {
                fragment.value = MainFragment.newInstance()
                return true
            }*/
        }
        return true
    }
}