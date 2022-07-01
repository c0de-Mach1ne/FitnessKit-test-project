package com.example.fitnesskittestproject.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittestproject.databinding.DateItemBinding
import com.example.fitnesskittestproject.databinding.TrainingItemBinding
import com.example.fitnesskittestproject.date.ResponseService
import com.example.fitnesskittestproject.model.DateItem
import com.example.fitnesskittestproject.model.Lesson
import com.example.fitnesskittestproject.model.ListItem

class TrainingAdapter(
    private val items: List<ListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ListItem.TYPE_DATE ->
                DateViewHolder(DateItemBinding.inflate(layoutInflater))
            else ->
                LessonViewHolder(TrainingItemBinding.inflate(layoutInflater))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ListItem.TYPE_DATE -> (holder as DateViewHolder).bind(
                item = items[position] as DateItem,
            )
            ListItem.TYPE_LESSON -> (holder as LessonViewHolder).bind(
                item = items[position] as Lesson
            )
        }
    }

    override fun getItemViewType(position: Int): Int = items[position].type

    override fun getItemCount(): Int = items.size

    inner class DateViewHolder(private val binding: DateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DateItem) {
            binding.tvGroupDate.text = item.date
        }
    }

    inner class LessonViewHolder(private val binding: TrainingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Lesson) {

            val trainers = ResponseService().getResponse(binding.tvTrainingName.context).trainers
            var name = ""
            trainers.forEach {
                if (it.id == item.coach_id) {
                    name = it.name
                }
            }

            binding.tvTimeStartTraining.text = item.startTime
            binding.tvTimeEndTraining.text = item.endTime
            binding.tvTrainingName.text = item.name
            binding.tvTrainingPlace.text = item.place
            binding.tvTrainingParticipants.text = name
            binding.ivUsers.isVisible = item.coach_id.isNotEmpty()
        }
    }
}