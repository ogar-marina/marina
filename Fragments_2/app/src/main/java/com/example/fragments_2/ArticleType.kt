package com.example.fragments_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
enum class ArticleType (val nameType: String): Parcelable {
    SPORT("Спорт"),
    BUSINESS("Бизнес"),
    HEALTH("Здоровье")
}
