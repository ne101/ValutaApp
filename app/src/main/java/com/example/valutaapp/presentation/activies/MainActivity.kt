package com.example.valutaapp.presentation.activies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.valutaapp.R
import com.example.valutaapp.databinding.ActivityMainBinding
import com.example.valutaapp.presentation.App
import com.example.valutaapp.presentation.adapters.ValutaAdapter
import com.example.valutaapp.presentation.viewModels.MainViewModel
import com.example.valutaapp.presentation.viewModels.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        val adapter = ValutaAdapter()
        binding.rvAdapter.adapter = adapter
        binding.rvAdapter.layoutManager = GridLayoutManager(this, 1)
        showData(adapter)
        showProgressBar()
        observeToast()

    }

    private fun showProgressBar() {
        viewModel.isLoading.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.INVISIBLE
            }
        }
    }


    private fun showData(adapter: ValutaAdapter) {
        viewModel.getData()
        viewModel.valutaList.observe(this) {
            adapter.submitList(it.Valute)
            binding.tvData.text = getString(R.string.Data, formatTime(it.Timestamp))
        }
    }

    private fun formatTime(time: String): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        val date = inputFormat.parse(time)
        return date?.let { outputFormat.format(it) }
    }

    private fun observeToast() {
        viewModel.toastMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}