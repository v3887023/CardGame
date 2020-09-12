package com.example.cardgame

import android.view.View
import com.example.cardgame.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_create_room.*

class CreateRoomFragment : BaseFragment(), View.OnClickListener {
    override val layoutId = R.layout.fragment_create_room

    override fun intViews() {
        toolbar.setNavigationOnClickListener { onBackPressed() }
        confirmCreateButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.confirmCreateButton -> loadFragment(
                R.id.fragment_container,
                WaitingRoomFragment(),
                true
            )
            else -> {
            }
        }
    }
}