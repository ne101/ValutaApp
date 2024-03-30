package com.example.valutaapp.di

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.valutaapp.presentation.activies.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [
    DataModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}