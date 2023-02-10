package com.example.pogoda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.pogoda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.state.observe(this) { state ->
            binding.today.text = state.todayTemp.toString()
            binding.yesterday.text = state.yesterdayTemp.toString()
            binding.tomorrow.text = state.tomorrowTemp.toString()

            binding.progressBar.isVisible = state.isLoading
        }
    }
}