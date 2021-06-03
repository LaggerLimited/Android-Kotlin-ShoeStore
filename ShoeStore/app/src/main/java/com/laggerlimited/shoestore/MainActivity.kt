package com.laggerlimited.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.laggerlimited.shoestore.databinding.ActivityMainBinding

/**
 * The MainActivity class holds each fragment and uses a Navigation Controller
 */
class MainActivity : AppCompatActivity() {
    // Binding object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Bind the activity_main layout to this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Get a reference to the NavHostFragment defined in the activity_main.xml
        val mainNavHostFragment = findNavController(R.id.mainNavHostFragment)
        // Get a reference to the AppBarConfiguration to manage the behavior of the navigation
        // button in the upper left corner
        val mainNavHostAppBar = AppBarConfiguration(mainNavHostFragment.graph)
        // Attach the mainToolbar defined in the activity_main.xml
        setSupportActionBar(findViewById(R.id.mainToolbar))
        // Now connect the mainNavHostFragment and the mainToolbar and setup Action bar with
        // navigation actions
        setupActionBarWithNavController(mainNavHostFragment, mainNavHostAppBar)
    }
}