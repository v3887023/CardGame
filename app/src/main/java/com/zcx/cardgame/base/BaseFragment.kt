package com.zcx.cardgame.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.zcx.cardgame.utils.MainHandler
import com.zcx.cardgame.utils.toast

abstract class BaseFragment : Fragment() {
    private var activity: Activity? = null
    private var rootView: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
    }

    private fun activityOrNull(): Activity? {
        return activity?.takeUnless { it.isDestroyed }
    }

    protected fun runOnUiThread(runnable: Runnable) {
        activityOrNull()?.run { MainHandler.runOnUiThread(runnable) }
    }

    protected fun showToast(text: CharSequence?) {
        activityOrNull()?.let { text?.toast(it) }
    }

    protected fun showToast(@StringRes resId: Int) {
        activityOrNull()?.let { resId.toast(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId, container, false)
        view.setOnKeyListener { _, _, _ -> handleBackEvent() }
        rootView = view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intViews()
    }

    protected fun setFullscreen(fullscreen: Boolean) {
        if (fullscreen) {
            activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    open fun handleBackEvent(): Boolean {
        return false
    }

    protected open fun intViews() {}

    protected fun <T : View> findViewById(@IdRes id: Int): T {
        return view?.findViewById(id) ?: throw KotlinNullPointerException()
    }

    protected fun loadFragment(
        contentViewId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false
    ) {
        if (activityOrNull() == null) {
            return
        }

        fragmentManager?.beginTransaction()?.apply {
            replace(contentViewId, fragment)
            if (addToBackStack) {
                addToBackStack(fragment.tag)
            }
            commit()
        }
    }

    protected fun onBackPressed() {
        activity?.onBackPressed()
    }

    abstract val layoutId: Int
}