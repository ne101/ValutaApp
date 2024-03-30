package com.example.valutaapp.data.mapper

import com.example.valutaapp.data.models.Currency
import com.example.valutaapp.data.models.ValutaResponse
import com.example.valutaapp.domain.entities.CurrencyEntity
import com.example.valutaapp.domain.entities.ValutaListEntity
import javax.inject.Inject

class Mapper @Inject constructor() {
    private fun mapCurrencyToEntity(currency: Currency): CurrencyEntity = CurrencyEntity(
        ID = currency.ID,
        Name = currency.Name,
        Value = currency.Value,
        CharCode = currency.CharCode,
        Nominal = currency.Nominal
    )
    fun mapValutaListToEntity(valutaResponse: ValutaResponse): ValutaListEntity = ValutaListEntity(
        Timestamp = valutaResponse.Timestamp,
        Valute = valutaResponse.Valute.entries.map { mapCurrencyToEntity(it.value) }

    )
}