package com.visuality.fragmentor.bridge

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.visuality.fragmentor.R
import com.visuality.fragmentor.engine.NavigationManager

val Fragment.fragmentor
    get() = this.activity?.let { activity ->
        NavigationManager(
            activity,
            R.id.fragmentorContainer
        )
    }

val Fragment.hasDefaultFragmentor
    get() = this.activity?.findViewById<View>(
        R.id.fragmentorContainer
    ) != null

fun Fragment.fragmentorForContainer(
    @IdRes containerId: Int
) = this.activity?.let { activity ->
    NavigationManager(
        activity,
        containerId
    )
}
