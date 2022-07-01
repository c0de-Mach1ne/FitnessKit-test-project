package com.example.fitnesskittestproject.main


import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittestproject.R
import com.example.fitnesskittestproject.date.App
import com.example.fitnesskittestproject.date.ResponseService
import com.example.fitnesskittestproject.model.Lesson

class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val startTime: TextView = itemView.findViewById(R.id.tv_timeStartTraining)
    private val endTime: TextView = itemView.findViewById(R.id.tv_timeEndTraining)
    private val trainingName: TextView = itemView.findViewById(R.id.tv_trainingName)
    private val trainingPlace: TextView = itemView.findViewById(R.id.tv_trainingPlace)
    private val trainingParticipants: TextView = itemView.findViewById(R.id.tv_trainingParticipants)
    private val ivParticipants: ImageView = itemView.findViewById(R.id.iv_users)

    private val response = ResponseService().getResponse(ivParticipants.context)

    fun onBind(lesson: Lesson) {

        val trainers = response.trainers
        var name = ""
        val coachName = trainers.forEach {
            if (it.id == lesson.coach_id){
                name = it.name
            }
        }

        startTime.text = lesson.startTime
        endTime.text = lesson.endTime
        trainingName.text = lesson.name
        trainingPlace.text = lesson.place
        trainingParticipants.text = name
        ivParticipants.isVisible = lesson.coach_id.isNotEmpty()

    }
}