package com.example.fitnesskittestproject.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesskittestproject.R
import com.example.fitnesskittestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, TrainingListFragment())
                .commit()
        }
    }
}