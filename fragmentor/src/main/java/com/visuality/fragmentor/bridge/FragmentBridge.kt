package com.visuality.fragmentor.bridge

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.visuality.fragmentor.R
import com.visuality.fragmentor.engine.NavigationManager

fun Fragment.fragmentor(
    @IdRes containerId: Int
) = this.activity?.let { activity ->
    NavigationManager(
        activity,
        containerId
    )
}

fun Fragment.fragmentor() = this.activity?.let { activity ->
    NavigationManager(
        activity,
        R.id.fragmentor
    )
}

fun Fragment.hasDefaultFragmentor() = this.activity?.findViewById<View>(
    R.id.fragmentor
) != null
