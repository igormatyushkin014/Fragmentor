package com.visuality.fragmentor.bridge

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import com.visuality.fragmentor.R
import com.visuality.fragmentor.engine.NavigationManager

val FragmentActivity.fragmentor
    get() = NavigationManager(
        this,
        R.id.fragmentorContainer
    )

val FragmentActivity.hasDefaultFragmentor
    get() = this.findViewById<View>(
        R.id.fragmentorContainer
    ) != null

fun FragmentActivity.fragmentorForContainer(
    @IdRes containerId: Int
) = NavigationManager(
    this,
    containerId
)
