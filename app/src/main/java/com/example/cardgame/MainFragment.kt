package com.example.cardgame

import android.view.View
import com.example.cardgame.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), View.OnClickListener {
    override val layoutId = R.layout.fragment_main

    override fun intViews() {
        wanButton.setOnClickListener(this)
        wlanButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.wanButton -> loadFragment(R.id.fragment_container, JoinRoomFragment(), true)
            R.id.wlanButton -> loadFragment(R.id.fragment_container, JoinRoomFragment(), true)
            else -> {
            }
        }
    }
}