package com.example.fragments_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var filtersForArticles: List<ArticleType>

    private val screens: List<OnboardingScreen> = listOf(
        OnboardingScreen(
            textRes = arrayOf(ArticleType.SPORT),
            titleRes = R.string.onboarding_title_1,
            articleRes = R.string.onboarding_article_1,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnboardingScreen(
            textRes = arrayOf(ArticleType.BUSINESS),
            titleRes = R.string.onboarding_title_2,
            articleRes = R.string.onboarding_article_2,
            drawableRes = R.drawable.onboarding_drawable_2
        ),
        OnboardingScreen(
            textRes = arrayOf(ArticleType.HEALTH),
            titleRes = R.string.onboarding_title_3,
            articleRes = R.string.onboarding_article_3,
            drawableRes = R.drawable.onboarding_drawable_3
        ),
        OnboardingScreen(
            textRes = arrayOf(ArticleType.SPORT),
            titleRes = R.string.onboarding_title_4,
            articleRes = R.string.onboarding_article_4,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnboardingScreen(
            textRes = arrayOf(ArticleType.BUSINESS),
            titleRes = R.string.onboarding_title_5,
            articleRes = R.string.onboarding_article_5,
            drawableRes = R.drawable.onboarding_drawable_2
        ),
        OnboardingScreen(
            textRes = arrayOf(ArticleType.HEALTH),
            titleRes = R.string.onboarding_title_6,
            articleRes = R.string.onboarding_article_6,
            drawableRes = R.drawable.onboarding_drawable_3
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDialogButton.setOnClickListener { showDialogWithSingleChoice() }

        val adapter = OnboardingAdapter(screens, this)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1

        viewPager.setCurrentItem(2, false)
        viewPager.currentItem

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.setPageTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                when {
                    position < -1 || position > 1 -> {
                        page.alpha = 0f
                    }

                    position <= 0 -> {
                        page.alpha = 1 + position
                    }

                    position <= 1 -> {
                        page.alpha = 1 - position
                    }
                }
            }
        })

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }

    private fun showDialogWithSingleChoice() {
        val typeArticle = ArticleType.values().map { it.nameId }.toTypedArray()
        AlertDialog.Builder(this)
            .setTitle("Выберете тип статьи:")
            .setItems(typeArticle) { _, which -> getFilterArticles() }
            .show()
        Log.d("filter article", "newList")
    }

    private fun getFilterArticles() = screens.filter { articleScreen ->
        arrayOf(ArticleType.values().map { it.nameId }.toTypedArray()).any {
            it.contentEquals(filtersForArticles.toTypedArray())

        }
    }
}



