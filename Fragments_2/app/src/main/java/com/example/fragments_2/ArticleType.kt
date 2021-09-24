package com.example.fragments_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
enum class ArticleType (val nameId: Int): Parcelable {
    SPORT(1),
    BUSINESS(2),
    HEALTH(3)
}
