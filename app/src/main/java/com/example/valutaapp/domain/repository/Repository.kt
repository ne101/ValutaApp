package com.example.valutaapp.domain.repository

import com.example.valutaapp.domain.entities.ValutaListEntity

interface Repository {

    suspend fun getValutaList(): ValutaListEntity

}