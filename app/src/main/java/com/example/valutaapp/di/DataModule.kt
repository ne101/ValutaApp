package com.example.valutaapp.di

import android.app.Application
import android.content.Context
import com.example.valutaapp.data.api.ApiFactory
import com.example.valutaapp.data.api.ApiService
import com.example.valutaapp.data.repositoryImpl.RepositoryImpl
import com.example.valutaapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRepositoryImpl(impl: RepositoryImpl): Repository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.apiService
    }
}