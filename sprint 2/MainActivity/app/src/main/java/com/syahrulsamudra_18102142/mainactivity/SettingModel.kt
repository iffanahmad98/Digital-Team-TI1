package com.syahrulsamudra_18102142.mainactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel (
    var isDarkTheme: Boolean = false
): Parcelable
