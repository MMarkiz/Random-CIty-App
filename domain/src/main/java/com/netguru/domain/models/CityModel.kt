package com.netguru.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityModel(
    val created: Long,
    val name: String,
    val color: String
) : Parcelable