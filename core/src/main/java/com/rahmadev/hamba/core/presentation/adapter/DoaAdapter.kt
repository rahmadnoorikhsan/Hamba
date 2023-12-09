package com.rahmadev.hamba.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahmadev.hamba.core.R
import com.rahmadev.hamba.core.databinding.ItemDoaBinding
import com.rahmadev.hamba.core.domain.model.doa.Doa

class DoaAdapter : ListAdapter<Doa, DoaAdapter.DoaViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaViewHolder {
        val binding = ItemDoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoaViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class DoaViewHolder(private val binding: ItemDoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doa: Doa) {
            binding.apply {
                tvNumber.text = itemView.context.getString(R.string.number_doa, doa.id.toString())
                tvTitle.text = doa.title
                tvArabic.text = doa.arab
                tvIndonesian.text = doa.indonesian
                tvTranslate.text = itemView.context.getString(R.string.doa_translate, doa.translate)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Doa>() {
            override fun areItemsTheSame(oldItem: Doa, newItem: Doa) = oldItem == newItem

            override fun areContentsTheSame(oldItem: Doa, newItem: Doa) = oldItem == newItem
        }
    }
}