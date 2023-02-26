package com.zcx.cardgame.utils

import android.content.Context
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * 输入法管理器的工具类
 *
 * @author 小雷
 * @date 2018/5/25
 */
object ImmHelper {
    /**
     * 隐藏输入法
     */
    fun hideSoftInput(context: Context, windowToken: IBinder?) {
        val imm = context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive && windowToken != null) {
            imm.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * 显示输入法
     */
    fun showSoftInput(context: Context, view: View?) {
        val imm = context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}