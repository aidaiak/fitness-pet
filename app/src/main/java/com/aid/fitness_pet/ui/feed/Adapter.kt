package com.aid.fitness_pet.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aid.fitness_pet.databinding.ItemFeedBinding
import com.bumptech.glide.Glide

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<FeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(data[position])
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        when (holder) {
            is ViewHolder -> holder.onViewRecycle()
        }
    }

    fun setItems(items: List<FeedItem>) {
        this.data.clear()
        this.data.addAll(items)
        notifyDataSetChanged()
    }

    private class ViewHolder(
        val binding: ItemFeedBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FeedItem) {
            Glide.with(itemView.context)
                .load(item.image)
                .into(binding.imageView)

            binding.topTextView.text = item.title
            binding.bottomTextView.text = item.description
        }

        fun onViewRecycle() {
            Glide.with(itemView.context).clear(binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}