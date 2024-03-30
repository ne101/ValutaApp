package com.example.valutaapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.valutaapp.domain.entities.CurrencyEntity
import com.example.valutaapp.domain.entities.ValutaListEntity

class ValutaDiffCallback : DiffUtil.ItemCallback<CurrencyEntity>() {
    override fun areItemsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean {
        return oldItem.ID == newItem.ID
    }

    override fun areContentsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean {
        return oldItem == newItem
    }

}