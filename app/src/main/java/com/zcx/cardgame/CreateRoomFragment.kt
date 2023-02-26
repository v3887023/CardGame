package com.zcx.cardgame

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.zcx.cardgame.base.BaseFragment

class CreateRoomFragment : BaseFragment(), View.OnClickListener {
    private lateinit var toolbar: Toolbar
    private lateinit var confirmCreateButton: Button

    override val layoutId = R.layout.fragment_create_room
    override fun intViews() {
        toolbar = findViewById(R.id.toolbar)
        confirmCreateButton = findViewById(R.id.actionButton)

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