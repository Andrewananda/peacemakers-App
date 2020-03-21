package com.example.peacemakers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.peacemakers.databinding.SermonItemBinding
import com.example.peacemakers.models.Sermon

class SermonAdapter : ListAdapter<Sermon,SermonAdapter.SermonViewHolder>(SermonDiffUtil) {

    inner class SermonViewHolder(val binding:SermonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.sermonTitle
        val description = binding.sermonDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SermonViewHolder {
        return SermonViewHolder(SermonItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SermonViewHolder, position: Int) {
        val item = getItem(position)
        holder.title.text = item.title
        holder.description.text = item.description

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