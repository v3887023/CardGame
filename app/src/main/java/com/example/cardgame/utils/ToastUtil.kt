package com.example.cardgame.utils

import android.content.Context
import android.widget.Toast
import com.example.cardgame.utils.MainHandler.runOnUiThread

fun CharSequence.toast(context: Context) {
    runOnUiThread { Toast.makeText(context, this, Toast.LENGTH_SHORT).show() }
}

fun Int.toast(context: Context) {
    context.getString(this).toast(context)
}