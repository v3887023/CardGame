package com.example.cardgame

import android.view.View
import com.example.cardgame.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_join_room.*

class JoinRoomFragment : BaseFragment(), View.OnClickListener {
    override val layoutId = R.layout.fragment_join_room

    override fun intViews() {
        toolbar.setNavigationOnClickListener { onBackPressed() }
        refreshButton.setOnClickListener(this)
        createRoomButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.refreshButton -> {
            }
            R.id.createRoomButton -> loadFragment(
                R.id.fragment_container,
                CreateRoomFragment(),
                true
            )
            else -> {
            }
        }
    }
}