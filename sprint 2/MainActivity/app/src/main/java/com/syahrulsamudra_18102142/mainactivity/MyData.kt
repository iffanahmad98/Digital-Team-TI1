package com.syahrulsamudra_18102142.mainactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String = "",
    var description: String = "",
    var photo: String = "",
    val lat: Double = 0.toDouble(),
    val lang: Double = 0.toDouble(),
    val price: Int = 0


) : Parcelable