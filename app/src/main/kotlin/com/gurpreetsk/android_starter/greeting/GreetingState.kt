package com.gurpreetsk.android_starter.greeting

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GreetingState(
        val greeting: String
) : Parcelable
