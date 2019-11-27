package com.gurpreetsk.android_starter.base

import android.os.Parcelable

interface MviView<in T : Parcelable> {
  fun render(state: T)
}
