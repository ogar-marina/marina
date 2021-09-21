package com.example.fragments_2

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingScreen(
    @StringRes val textRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val articleRes: Int,
    @ColorRes val bgColorRes: Int,
    @DrawableRes val drawableRes: Int
) {
}