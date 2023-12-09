package com.rahmadev.hamba.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahmadev.hamba.core.R
import com.rahmadev.hamba.core.databinding.ItemHadithBinding
import com.rahmadev.hamba.core.domain.model.hadith.Hadith

class HadithAdapter: ListAdapter<Hadith, HadithAdapter.HadithViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        val binding = ItemHadithBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadithViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) = holder.bind(getItem(position))

    inner class HadithViewHolder(private val binding: ItemHadithBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hadith: Hadith) {
            binding.apply {
                tvNumber.text = hadith.number.toString()
                tvArabic.text = hadith.arab
                tvTranslate.text = itemView.context.getString(R.string.hadith_translate, hadith.translate)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Hadith>() {
            override fun areItemsTheSame(oldItem: Hadith, newItem: Hadith) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Hadith, newItem: Hadith) = oldItem == newItem
        }
    }
}