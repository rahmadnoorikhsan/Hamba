package com.rahmadev.hamba.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahmadev.hamba.core.databinding.ItemAdzanBinding
import com.rahmadev.hamba.core.domain.model.adzan.Adzan

class AdzanAdapter: ListAdapter<Adzan, AdzanAdapter.AdzanViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdzanViewHolder {
        val binding = ItemAdzanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdzanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdzanViewHolder, position: Int) = holder.bind(getItem(position))

    inner class AdzanViewHolder(private val binding: ItemAdzanBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(adzan: Adzan) {
            binding.apply {
                tvArabic.text = adzan.arabic
                tvTranslate.text = adzan.translate
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Adzan>() {
            override fun areItemsTheSame(oldItem: Adzan, newItem: Adzan) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Adzan, newItem: Adzan) = oldItem == newItem
        }
    }
}