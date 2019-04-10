package com.visuality.fragmentor.bridge

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import com.visuality.fragmentor.R
import com.visuality.fragmentor.engine.NavigationManager

fun FragmentActivity.fragmentor(
    @IdRes containerId: Int
) = NavigationManager(
    this,
    containerId
)

fun FragmentActivity.fragmentor() = NavigationManager(
    this,
    R.id.fragmentor
)

fun FragmentActivity.hasDefaultFragmentor() = this.findViewById<View>(
    R.id.fragmentor
) != null
