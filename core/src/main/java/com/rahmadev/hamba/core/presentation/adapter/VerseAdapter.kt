package com.rahmadev.hamba.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahmadev.hamba.core.databinding.ItemVerseBinding
import com.rahmadev.hamba.core.domain.model.quran.Verses

class VerseAdapter : ListAdapter<Verses, VerseAdapter.VerseViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) = holder.bind(getItem(position))

    inner class VerseViewHolder(private val binding: ItemVerseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(verses: Verses) {
            binding.apply {
                tvNumber.text = verses.id.toString()
                tvArabic.text = verses.arabic
                tvTranslate.text = verses.translate
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Verses>() {
            override fun areItemsTheSame(oldItem: Verses, newItem: Verses) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Verses, newItem: Verses) = oldItem == newItem
        }
    }
}