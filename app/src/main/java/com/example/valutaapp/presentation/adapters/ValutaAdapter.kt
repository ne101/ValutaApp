package com.example.valutaapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.valutaapp.R
import com.example.valutaapp.databinding.ValutaCardBinding
import com.example.valutaapp.domain.entities.CurrencyEntity

class ValutaAdapter : ListAdapter<CurrencyEntity, ValutaViewHolder>(ValutaDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValutaViewHolder {
        val binding = ValutaCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ValutaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ValutaViewHolder, position: Int) {
        val binding = holder.binding
        val item = getItem(position)
        val context = holder.itemView.context
        with(binding) {
            with(item) {
                tvName.text = Name
                tvValue.text = context.getString(R.string.value, Value.toString())
                tvvNominal.text = Nominal
                tvCharCode.text = context.getString(R.string.CharCode, CharCode)
            }
        }
    }
}