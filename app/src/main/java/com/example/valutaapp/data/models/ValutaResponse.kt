package com.example.valutaapp.data.models

import com.google.gson.annotations.SerializedName

data class ValutaResponse(
    @SerializedName("Timestamp")
    val Timestamp: String,
    @SerializedName("Valute")
    val Valute: Map<String, Currency>
)

