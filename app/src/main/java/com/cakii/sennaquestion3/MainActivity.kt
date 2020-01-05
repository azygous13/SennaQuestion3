package com.cakii.sennaquestion3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportFragmentManager.commit {
            setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            add(R.id.fragment_container, RestaurantsFragment.newInstance())
        }
    }
}
