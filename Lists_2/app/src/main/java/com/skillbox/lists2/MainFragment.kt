package com.skillbox.lists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main), Navigation {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lists1.setOnClickListener { navigateTo(PersonListFragment()) }
        LinearLayout.setOnClickListener { navigateTo(LinearListFragment()) }
        GridLayout.setOnClickListener { navigateTo(GridListFragment()) }
        StaggeredGridLayout.setOnClickListener { navigateTo(StaggeredListFragment()) }
    }

    override fun navigateTo(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.container2, fragment)
            .commit()
    }
}