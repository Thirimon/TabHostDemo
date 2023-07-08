package com.example.tabhostdemo

import android.app.ActivityGroup
import android.app.LocalActivityManager
import android.content.Intent
import android.os.Bundle
import android.widget.TabHost
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ActivityGroup() {
    lateinit var tabHost:TabHost
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabHost = findViewById<TabHost>(R.id.tabHost)
        setupTabHost()

    }
    private fun setupTabHost() {
        tabHost.setup(this.localActivityManager)

        addTab(
            tabHost,
            getString(R.string.home),
            getString(R.string.home),
            HomeActivity::class.java
        )
        addTab(
            tabHost,
            getString(R.string.textswitcher),
            getString(R.string.textswitcher),
            TextSwitcherActivity::class.java
        )
        addTab(
            tabHost,
            getString(R.string.ImageSwitcher),
            getString(R.string.ImageSwitcher),
            ImageSwitcherActivity::class.java
        )

        tabHost.currentTab = 1
        tabHost.setOnTabChangedListener { tabId ->
            Toast.makeText(
                applicationContext,
                tabId,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, className: Class<*>) {
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
    }

}