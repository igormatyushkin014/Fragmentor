package com.visuality.fragmentordemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.visuality.fragmentor.bridge.fragmentor
import com.visuality.fragmentordemo.R
import com.visuality.fragmentordemo.fragments.OneFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        fragmentor.push(OneFragment())
    }

    override fun onBackPressed() {
        fragmentor.onBackPressed()
    }
}
