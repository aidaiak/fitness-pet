package com.aid.fitness_pet.ui.schedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aid.fitness_pet.databinding.ItemScheduleBinding

class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<Schedule>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(data[position])
        }
    }

    fun setItems(items: List<Schedule>) {
        this.data.clear()
        this.data.addAll(items)
        notifyDataSetChanged()
    }

    private class ViewHolder(
        val binding: ItemScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Schedule) {
            binding.topTextView.text = "${item.time}\n${item.trainingType}"
            binding.textView.text = item.name + "\n" + item.trainerName
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}