package com.example.peacemakers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.peacemakers.databinding.SermonItemBinding
import com.example.peacemakers.models.Sermon

class SermonAdapter(val clickListener:SermonClickListener) : ListAdapter<Sermon,SermonAdapter.SermonViewHolder>(SermonDiffUtil) {

    inner class SermonViewHolder(val binding:SermonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sermon){
            binding.sermonTitle.text = item.title
            binding.sermonDescription.text = item.description
            binding.sermonBy.text = item.sermon_by
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SermonViewHolder {
        return SermonViewHolder(SermonItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SermonViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
        holder.bind(item)
    }

    companion object SermonDiffUtil:DiffUtil.ItemCallback<Sermon>(){
        override fun areItemsTheSame(oldItem: Sermon, newItem: Sermon): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Sermon, newItem: Sermon): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

class SermonClickListener(val clickListener: (sermonId: Int) -> Unit) {
    fun onClick(sermon: Sermon) = clickListener(sermon.id)
}