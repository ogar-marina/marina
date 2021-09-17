package com.example.fragments_1

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment

class ListFragment : Fragment(R.layout.fragment_list) {

    private val itemSelectListener: ItemSelectListener?
        get() = parentFragment?.let { it as? ItemSelectListener }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.let { it as ViewGroup }
            .children
            .mapNotNull { it as? Button }
            .forEach { button ->
                button.setOnClickListener {
                    onButtonClick(button.text.toString())
                }
            }
    }

    private fun onButtonClick(buttonText: String) {
        itemSelectListener?.onItemSelected(buttonText)

    }
}