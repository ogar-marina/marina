package com.example.fragments_2

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnboardingScreen(
    val textRes: Array<ArticleType>,
    @StringRes val titleRes: Int,
    @StringRes val articleRes: Int,
    @DrawableRes val drawableRes: Int
):Parcelable
