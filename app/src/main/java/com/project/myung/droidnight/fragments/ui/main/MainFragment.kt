package com.project.myung.droidnight.fragments.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import com.project.myung.droidnight.R
import com.project.myung.droidnight.base.BaseFragment
import com.project.myung.droidnight.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*
import android.content.Intent
import android.net.Uri


class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel

        btn_find.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/?queryType=departure&elng=7a80bd1f08a47b1b065ef9b62f65905d&menu=routemapMode%3D0&elat=d8ace5a498bdc6e338737b12c03e0f1e&eText=%5B%EC%98%A4%ED%94%88%ED%8A%B9%EA%B0%80%5D%EB%AA%A9%EB%8F%99%ED%8C%8C%ED%8B%B0%EB%A3%B8+%EB%B9%84%EB%B0%94%ED%8C%8C%ED%8B%B0%EB%A3%B8&pinType=site&dlevel=12&enc=utf8"))
            startActivity(intent)
        }
    }

}
