package com.example.valutaapp.presentation

import android.app.Application
import com.example.valutaapp.di.DaggerApplicationComponent

class App : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}