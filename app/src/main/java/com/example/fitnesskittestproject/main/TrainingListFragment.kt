package com.example.fitnesskittestproject.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitnesskittestproject.databinding.TraininglistFragmentBinding

class TrainingListFragment: Fragment() {
    private lateinit var binding: TraininglistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TraininglistFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}