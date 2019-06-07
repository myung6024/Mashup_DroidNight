package com.project.myung.droidnight.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.myung.droidnight.R
import com.project.myung.droidnight.base.BaseActivity
import com.project.myung.droidnight.databinding.ActivityMainBinding
import com.project.myung.droidnight.fragments.ui.main.MainFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewDataBinding.root)
        viewDataBinding.viewModel = viewModel

        replaceFragment(MainFragment())
        viewModel.fragment.observe(this, Observer {
            replaceFragment(it)
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(viewDataBinding.frame.id, fragment)
        transaction.commit()
    }
}
