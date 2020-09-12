package com.example.cardgame.utils

import android.os.Handler
import android.os.Looper

object MainHandler {
    private val handler = Handler(Looper.getMainLooper())

    fun runOnUiThread(runnable: Runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run()
        } else {
            handler.post(runnable)
        }
    }
}