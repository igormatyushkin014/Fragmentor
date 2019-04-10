package com.visuality.fragmentor.engine

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class NavigationManager(
    private val activity: FragmentActivity,
    @IdRes private val containerId: Int
) {

    val stack = NavigationStack(
        this.activity.supportFragmentManager
    )

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
    }

    fun push(
        fragments: Array<out Fragment>
    ) {
        this.activity.supportFragmentManager
            .beginTransaction()
            .also {  transaction ->
                for (fragment in fragments) {
                    transaction.add(
                        this.containerId,
                        fragment
                    )
                }
            }
            .commit()
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
