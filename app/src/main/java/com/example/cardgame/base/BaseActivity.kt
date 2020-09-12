package com.example.cardgame.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = layoutId
        if (layoutId != 0) {
            setContentView(layoutId)
        }
    }

    protected fun setFullscreen(fullscreen: Boolean) {
        if (isDestroyed) {
            return
        }

        if (fullscreen) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    protected fun loadFragment(
        contentViewId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false
    ) {
        val fragmentManager = supportFragmentManager
        val ft = fragmentManager.beginTransaction()
        ft.replace(contentViewId, fragment)
        if (addToBackStack) {
            ft.addToBackStack(fragment.tag)
        }
        ft.commit()
    }
}