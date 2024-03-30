package com.example.valutaapp.data.models

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("ID")
    val ID: String,
    @SerializedName("Name")
    val Name: String,
    @SerializedName("Value")
    val Value: Double,
    @SerializedName("CharCode")
    val CharCode: String,
    @SerializedName("Nominal")
    val Nominal: String
)
