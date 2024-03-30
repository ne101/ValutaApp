package com.example.valutaapp.presentation.viewModels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valutaapp.domain.entities.ValutaListEntity
import com.example.valutaapp.domain.usecases.GetValutaListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getValutaListUseCase: GetValutaListUseCase,
    private val application: Application
) : ViewModel() {
    private val _valutaList = MutableLiveData<ValutaListEntity>()
    val valutaList: LiveData<ValutaListEntity>
        get() = _valutaList
    private val _isLoading = MutableLiveData<Boolean>()
        val isLoading: LiveData<Boolean>
            get() = _isLoading
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String>
        get() = _toastMessage

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                if (isNetworkAvailable()) {
                    _isLoading.postValue(true)
                    try {
                        _valutaList.postValue(getValutaListUseCase.invoke())
                    } catch (e: Exception) {
                        Log.e("MainViewModel", "Error fetching data", e)
                    }
                    _isLoading.postValue(false)
                } else {
                    _toastMessage.postValue("No internet connection")
                }
                delay(30000)
            }
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}