package com.example.fragments_2

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment: Fragment(R.layout.fragment_onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().setBackgroundResource(requireArguments().getInt(KEY_COLOR))
        enum_textView.setText(requireArguments().getInt(KEY_TEXT))
        title.setText(requireArguments().getInt(KEY_TITLE))
        article.setText(requireArguments().getInt(KEY_ARTICLE))
        imageView.setImageResource(requireArguments().getInt(KEY_IMAGE))
    }

    companion object{

        private const val KEY_TEXT = "text"
        private const val KEY_TITLE = "title"
        private const val KEY_ARTICLE = "article"
        private const val KEY_COLOR = "color"
        private const val KEY_IMAGE = "image"


        fun newInstance(
            @StringRes textRes: Int,
            @StringRes titleRes: Int,
            @StringRes articleRes: Int,
            @ColorRes bgColorRes: Int,
            @DrawableRes drawableRes: Int
        ): OnboardingFragment{
            return OnboardingFragment().withArguments{
                putInt(KEY_TEXT, textRes)
                putInt(KEY_TITLE, titleRes)
                putInt(KEY_ARTICLE, articleRes)
                putInt(KEY_COLOR, bgColorRes)
                putInt(KEY_IMAGE, drawableRes)
            }
        }
    }
}