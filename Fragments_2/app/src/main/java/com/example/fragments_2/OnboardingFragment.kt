package com.example.fragments_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = requireArguments().getParcelable<OnboardingScreen>(KEY_ARTICLE)

        if (article!=null){
            title.setText(article.titleRes) //название статьи
            articleText.setText(article.articleRes) //текст статьи
            imageView.setImageResource(article.drawableRes) //фото
        }
    }

    companion object {

        private const val KEY_ARTICLE = "article"

        fun newInstance(article: OnboardingScreen): OnboardingFragment {
            return OnboardingFragment().withArguments {
                putParcelable(KEY_ARTICLE, article)
            }
        }
    }
}
