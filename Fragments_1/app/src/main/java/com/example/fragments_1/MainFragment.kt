package com.example.fragments_1

import android.os.Bundle
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateTo(ListFragment())
    }

    override fun navigateTo(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.container2, fragment)
            .commit()
    }
}