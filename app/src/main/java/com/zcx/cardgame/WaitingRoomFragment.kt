package com.zcx.cardgame

import android.view.View
import android.widget.Button
import android.widget.Toolbar
import com.zcx.cardgame.base.BaseFragment

class WaitingRoomFragment : BaseFragment(), View.OnClickListener {
    private lateinit var toolbar: Toolbar
    private lateinit var actionButton: Button

    override val layoutId = R.layout.fragment_waiting_room

    override fun intViews() {
        toolbar = findViewById(R.id.toolbar)
        actionButton = findViewById(R.id.actionButton)

        toolbar.setNavigationOnClickListener { onBackPressed() }
        actionButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.actionButton -> loadFragment(R.id.fragment_container, GameFragment(), true)
            else -> {
            }
        }
    }
}