package com.visuality.fragmentordemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.visuality.fragmentor.bridge.fragmentor
import com.visuality.fragmentordemo.R

class OneFragment : Fragment() {

    private val nextButton by lazy {
        this.view!!.findViewById<Button>(R.id.next_button)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_one,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        this.prepareNextButton()
    }

    private fun prepareNextButton() {
        this.nextButton.setOnClickListener {
            fragmentor?.push(
                TwoFragment()
            )
        }
    }
}
