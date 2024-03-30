package com.example.valutaapp.data.repositoryImpl

import com.example.valutaapp.data.api.ApiService
import com.example.valutaapp.data.mapper.Mapper
import com.example.valutaapp.domain.entities.ValutaListEntity
import com.example.valutaapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper
) : Repository {
    override suspend fun getValutaList(): ValutaListEntity {
            val response = apiService.loadValutaList()
            return mapper.mapValutaListToEntity(response)
    }
}