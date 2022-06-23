package com.example.fitnesskittestproject.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittestproject.R
import com.example.fitnesskittestproject.databinding.TraininglistFragmentBinding
import com.example.fitnesskittestproject.date.App
import com.example.fitnesskittestproject.date.ResponseService
import com.google.gson.GsonBuilder

class TrainingListFragment : Fragment() {

    private lateinit var adapter: TrainingAdapter
    private lateinit var binding: TraininglistFragmentBinding
    private val gson = GsonBuilder().create()

    val responseService: ResponseService
        get() = (activity?.applicationContext as App).responseService


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TraininglistFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler: RecyclerView = view.findViewById(R.id.recyclerView)
        adapter = TrainingAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    private fun updateData() {
        adapter.bindLessonList(responseService.getResponse(binding.recyclerView.context).lessons)
        adapter.notifyDataSetChanged()
    }

    private fun readAssetFileToString(fileName: String): String {
        val stream = requireContext().assets.open(fileName)
        return stream.bufferedReader().readText()
    }
}