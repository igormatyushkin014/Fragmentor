package com.visuality.fragmentordemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.visuality.fragmentor.bridge.fragmentor
import com.visuality.fragmentordemo.R

class TwoFragment : Fragment() {

    private val previousButton by lazy {
        this.view!!.findViewById<Button>(R.id.previous_button)
    }

    private val nextButton by lazy {
        this.view!!.findViewById<Button>(R.id.next_button)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_two,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        this.preparePreviousButton()
        this.prepareNextButton()
    }

    private fun preparePreviousButton() {
        this.previousButton.setOnClickListener {
            fragmentor()?.pop()
        }
    }

    private fun prepareNextButton() {
        this.nextButton.setOnClickListener {
            fragmentor()?.push(
                ThreeFragment()
            )
        }
    }
}
