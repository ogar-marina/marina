package com.example.fragments_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val screens: List<OnboardingScreen> = listOf(
        OnboardingScreen(
            textRes = R.string.onboarding_text_1,
            titleRes = R.string.onboarding_title_1,
            articleRes = R.string.onboarding_article_1,
            bgColorRes = R.color.onboarding_color_1,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnboardingScreen(
            textRes = R.string.onboarding_text_2,
            titleRes = R.string.onboarding_title_2,
            articleRes = R.string.onboarding_article_2,
            bgColorRes = R.color.onboarding_color_2,
            drawableRes = R.drawable.onboarding_drawable_2
        ),
        OnboardingScreen(
            textRes = R.string.onboarding_text_3,
            titleRes = R.string.onboarding_title_3,
            articleRes = R.string.onboarding_article_3,
            bgColorRes = R.color.onboarding_color_3,
            drawableRes = R.drawable.onboarding_drawable_3
        ),
        OnboardingScreen(
            textRes = R.string.onboarding_text_1,
            titleRes = R.string.onboarding_title_4,
            articleRes = R.string.onboarding_article_4,
            bgColorRes = R.color.onboarding_color_1,
            drawableRes = R.drawable.onboarding_drawable_1
        ),
        OnboardingScreen(
            textRes = R.string.onboarding_text_2,
            titleRes = R.string.onboarding_title_5,
            articleRes = R.string.onboarding_article_5,
            bgColorRes = R.color.onboarding_color_2,
            drawableRes = R.drawable.onboarding_drawable_2
        ),
        OnboardingScreen(
            textRes = R.string.onboarding_text_3,
            titleRes = R.string.onboarding_title_6,
            articleRes = R.string.onboarding_article_6,
            bgColorRes = R.color.onboarding_color_3,
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
        val typeArticle = arrayOf("Спорт", "Бизнес", "Здоровье")
        AlertDialog.Builder(this)
            .setTitle("Выберете тип статьи:")
            .setItems(typeArticle) { _, which -> toast("Выбран тип: ${typeArticle[which]}") }
            .show()
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
