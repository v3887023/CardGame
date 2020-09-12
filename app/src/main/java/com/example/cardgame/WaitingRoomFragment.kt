package com.example.cardgame

import android.view.View
import com.example.cardgame.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_waiting_room.*

class WaitingRoomFragment : BaseFragment(), View.OnClickListener {
    override val layoutId = R.layout.fragment_waiting_room

    override fun intViews() {
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