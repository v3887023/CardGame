package com.zcx.cardgame

import android.view.View
import android.widget.Button
import android.widget.Toolbar
import com.zcx.cardgame.base.BaseFragment

class JoinRoomFragment : BaseFragment(), View.OnClickListener {
    private lateinit var toolbar: Toolbar
    private lateinit var refreshButton: Button
    private lateinit var createRoomButton: Button

    override val layoutId = R.layout.fragment_join_room

    override fun intViews() {
        toolbar = findViewById(R.id.toolbar)
        refreshButton = findViewById(R.id.actionButton)
        createRoomButton = findViewById(R.id.actionButton)

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