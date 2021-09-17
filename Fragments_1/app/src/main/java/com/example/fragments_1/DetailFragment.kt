package com.example.fragments_1

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment(R.layout.fragment_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inputTextView.text = requireArguments().getString(KEY_TEXT)
    }

    companion object {
        private const val KEY_TEXT = "key_text"

        fun newInstance(text:String): ListFragment{
            return ListFragment().withArguments{
                putString(KEY_TEXT, text)
            }
        }
    }
}