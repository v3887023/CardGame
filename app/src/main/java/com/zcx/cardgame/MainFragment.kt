package com.zcx.cardgame

import android.view.View
import android.widget.Button
import com.zcx.cardgame.base.BaseFragment

class MainFragment : BaseFragment(), View.OnClickListener {
    private lateinit var wanButton: Button
    private lateinit var wlanButton: Button

    override val layoutId = R.layout.fragment_main

    override fun intViews() {
        wanButton = findViewById(R.id.toolbar)
        wlanButton = findViewById(R.id.actionButton)
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