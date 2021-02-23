package com.example.task_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.task_ui.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        instance = this


        val navController = Navigation.findNavController(this, R.id.home_nav_host_fragment)
       NavigationUI.setupWithNavController(bottomNavigationView, navController)




    }



    companion object {

        lateinit var instance: MainActivity


    }
}