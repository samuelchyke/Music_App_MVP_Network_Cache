package com.itc.music_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itc.music_app.R
import com.itc.music_app.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()

    }

    private fun setUpTabs() {
        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(RockFragment())
        adapter.addFragment(ClassicFragment())
        adapter.addFragment(PopFragment())
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_classic)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_pop)

    }
}