package com.zcx.cardgame

import android.os.Bundle
import com.zcx.cardgame.base.BaseActivity

class MainActivity : BaseActivity() {
    override val layoutId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        setFullscreen(true)
        super.onCreate(savedInstanceState)

        loadFragment(R.id.fragment_container, MainFragment())
    }
}