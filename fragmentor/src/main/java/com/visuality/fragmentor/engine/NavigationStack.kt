package com.visuality.fragmentor.engine

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NavigationStack internal constructor(
    private val fragmentManager: FragmentManager
) {

    fun isEmpty() = this.fragmentManager.fragments.isEmpty()

    fun getCount() = this.fragmentManager.fragments.count()

    fun getFragment(index: Int): Fragment? {
        val fragments = this.fragmentManager.fragments

        return if (0 <= index && index <= fragments.lastIndex) {
            this.fragmentManager.fragments[index]
        } else {
            null
        }
    }

    fun getBottom(): Fragment? = this.getFragment(
        index = 0
    )

    fun getTop() = this.getFragment(
        index = this.fragmentManager.fragments.lastIndex
    )
}
