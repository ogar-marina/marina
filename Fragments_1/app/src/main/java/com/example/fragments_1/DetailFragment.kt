package com.example.fragments_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputTextView.text = requireArguments().getString(KEY_TEXT)
    }

    companion object {
        private const val KEY_TEXT = "key_text"

        fun newInstance(text:String): DetailFragment{
            return DetailFragment().withArguments{
                putString(KEY_TEXT, text)
            }
        }
    }
}