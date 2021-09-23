package com.example.fragments_2

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize


@Parcelize
enum class ArticleType: Parcelable {
    SPORT,
    BUSINESS,
    HEALTH
}
