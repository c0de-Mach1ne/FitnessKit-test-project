package com.example.fitnesskittestproject.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.fitnesskittestproject.R
import com.example.fitnesskittestproject.databinding.ActivityMainBinding
import com.google.android.material.internal.ContextUtils.getActivity

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

    companion object{
        @SuppressLint("StaticFieldLeak")
        val context: Context = MainActivity.context
    }
}