package com.skillbox.multithreading.threading.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.skillbox.multithreading.R
import com.skillbox.multithreading.threading.ThreadingViewModel
import com.skillbox.multithreading.threading.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_threading.*

class ThreadingFragment : Fragment(R.layout.fragment_threading) {
    private val viewModel: ThreadingViewModel by viewModels()

    private val handler = Handler(Looper.getMainLooper())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestMovies.setOnClickListener {
            viewModel.requestMovies()
        }
        viewModel.time.observe(viewLifecycleOwner) {
            Log.d("ThreadTest", "livedata changed on ${Thread.currentThread().name}")
            timeTextView.text = it.toString()
        }

        val adapter = MoviesAdapter()

        recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.setData(it)
            handler.postDelayed({
                Toast.makeText(requireContext(), "Displayed!", LENGTH_SHORT).show()
            }, 1_000L)
        }
    }

}