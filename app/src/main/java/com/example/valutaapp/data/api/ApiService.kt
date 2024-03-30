package com.example.valutaapp.data.api

import com.example.valutaapp.data.models.ValutaResponse
import retrofit2.http.GET

interface ApiService {

    @GET("daily_json.js")
    suspend fun loadValutaList(): ValutaResponse

}