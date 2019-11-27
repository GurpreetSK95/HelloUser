package com.gurpreetsk.android_starter.di.components

import android.content.Context
import com.gurpreetsk.android_starter.MainApplication
import com.gurpreetsk.android_starter.di.AppComponent
import com.gurpreetsk.android_starter.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {
  // TODO: Define contract

  companion object {
    fun obtain(context: Context): ActivityComponent =
        (context.applicationContext as MainApplication).activityComponent()
  }
}
