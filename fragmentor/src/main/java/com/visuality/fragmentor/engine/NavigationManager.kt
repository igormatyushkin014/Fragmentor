package com.visuality.fragmentor.engine

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class NavigationManager internal constructor(
    private val activity: FragmentActivity,
    @IdRes private val containerId: Int
) {

    val stack = NavigationStack(
        this.activity.supportFragmentManager
    )

    private fun prepareFragmentForUse(fragment: Fragment) {
        fragment.view?.let { view ->
            if (view.background == null) {
                view.setBackgroundColor(
                    Color.WHITE
                )
            }

            view.isClickable = true
            view.isFocusable = true
        }
    }

    fun push(
        fragment: Fragment
    ) {
        this.activity.supportFragmentManager
            .beginTransaction()
            .add(
                this.containerId,
                fragment
            )
            .addToBackStack(null)
            .commit()

        Handler(Looper.getMainLooper()).post {
            this.prepareFragmentForUse(fragment)
        }
    }

    fun push(
        fragments: Array<out Fragment>
    ) {
        for (fragment in fragments) {
            this.activity.supportFragmentManager
                .beginTransaction()
                .add(
                    this.containerId,
                    fragment
                )
                .addToBackStack(null)
                .commit()
        }

        Handler(Looper.getMainLooper()).post {
            for (fragment in fragments) {
                this.prepareFragmentForUse(fragment)
            }
        }
    }

    fun pop() {
        this.activity.supportFragmentManager.popBackStack()
    }

    fun popToBottom() {
        if (this.stack.getCount() < 2) {
            return
        }

        val transaction = this.activity.supportFragmentManager.beginTransaction()

        for (i in this.stack.getCount() - 1 downTo 1) {
            val fragment = this.stack.getFragment(i)!!
            transaction.remove(fragment)
        }

        transaction.commit()
    }

    fun clear() {
        this.activity.supportFragmentManager
            .beginTransaction()
            .also { transaction ->
                for (fragment in this.activity.supportFragmentManager.fragments) {
                    transaction.remove(fragment)
                }
            }
            .commit()
    }

    fun onBackPressed() {
        if (this.stack.getCount() > 1) {
            this.pop()
        } else {
            this.activity.finish()
        }
    }
}
