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
import com.example.fitnesskittestproject.model.DateItem
import com.example.fitnesskittestproject.model.Lesson
import com.example.fitnesskittestproject.model.ListItem

class TrainingListFragment : Fragment() {

    private lateinit var adapter: TrainingAdapter
    private lateinit var binding: TraininglistFragmentBinding
    private val responseService: ResponseService
        get() = (activity?.applicationContext as App).responseService


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TraininglistFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler: RecyclerView = view.findViewById(R.id.recyclerView)

        val groupMapMap: Map<String, List<Lesson>> =
            responseService.getResponse(requireContext()).lessons.groupBy {
                it.date
            }

        val sorted = groupMapMap.toSortedMap().toMutableMap()
        val newSortedMap = mutableMapOf<String, List<Lesson>>()

        for (date: String in sorted.keys) {
            sorted[date]?.sortedBy { it.startTime }?.let { newSortedMap.put(date, it) }
        }

        val consolidatedList = mutableListOf<ListItem>()
        for (date: String in newSortedMap.keys) {
            consolidatedList.add(DateItem(date))
            val groupItems: List<Lesson>? = newSortedMap[date]
            groupItems?.forEach {
                consolidatedList.add(
                    Lesson(
                        it.appointment_id,
                        it.available_slots,
                        it.client_recorded,
                        it.coach_id,
                        it.color,
                        it.commercial,
                        it.date,
                        it.description,
                        it.endTime,
                        it.is_cancelled,
                        it.name,
                        it.place,
                        it.service_id,
                        it.startTime,
                        it.tab,
                        it.tab_id,
                    )
                )
            }
        }

        adapter = TrainingAdapter(consolidatedList)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }
}