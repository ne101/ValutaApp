package com.example.valutaapp.domain.usecases

import com.example.valutaapp.domain.entities.ValutaListEntity
import com.example.valutaapp.domain.repository.Repository
import javax.inject.Inject

class GetValutaListUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): ValutaListEntity {
        return repository.getValutaList()
    }
}