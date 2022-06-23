package com.example.fitnesskittestproject.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittestproject.R
import com.example.fitnesskittestproject.model.Lesson

class TrainingAdapter: RecyclerView.Adapter<TrainingViewHolder>() {

    private var lessonList = listOf<Lesson>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.training_item, parent, false)

        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.onBind(lessonList[position])
    }

    override fun getItemCount(): Int = lessonList.size

    fun bindLessonList(newLessonList: List<Lesson>){
        lessonList = newLessonList
    }
}