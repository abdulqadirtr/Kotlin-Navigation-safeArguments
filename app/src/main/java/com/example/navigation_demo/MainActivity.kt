package com.example.navigation_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var navControl: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_home) as NavHostFragment
            navControl = navHostFragment.navController
        setupActionBarWithNavController(navControl)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navControl.navigateUp()
                || super.onSupportNavigateUp()
    }
}