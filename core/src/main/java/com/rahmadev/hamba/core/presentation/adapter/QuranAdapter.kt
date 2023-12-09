package com.rahmadev.hamba.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahmadev.hamba.core.R
import com.rahmadev.hamba.core.databinding.ItemSurahBinding
import com.rahmadev.hamba.core.domain.model.quran.Quran

class QuranAdapter(val id: (Int) -> Unit) :
    ListAdapter<Quran, QuranAdapter.QuranViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class QuranViewHolder(private val binding: ItemSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quran: Quran) {
            binding.apply {
                tvNumber.text = quran.number.toString()
                tvArabic.text = quran.name
                tvIndonesian.text = quran.latin
                tvType.text = itemView.context.getString(
                    R.string.surah_type,
                    quran.type,
                    quran.translate
                )
            }

            itemView.setOnClickListener { quran.number?.let { id.invoke(it) } }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Quran>() {
            override fun areItemsTheSame(oldItem: Quran, newItem: Quran) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Quran, newItem: Quran) = oldItem == newItem
        }
    }
}