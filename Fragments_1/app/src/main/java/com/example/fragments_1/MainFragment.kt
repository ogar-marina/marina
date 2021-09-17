package com.example.fragments_1

import android.os.Bundle
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main), ItemSelectListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.container2, ListFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onItemSelected(text: String) {
        childFragmentManager.beginTransaction()
            .replace(R.id.container2, DetailFragment.newInstance(text))
            .commit()
    }
}