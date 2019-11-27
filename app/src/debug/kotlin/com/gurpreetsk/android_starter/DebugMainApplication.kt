package com.gurpreetsk.android_starter

import com.facebook.stetho.Stetho
import com.gurpreetsk.android_starter.di.AppComponent
import com.gurpreetsk.android_starter.di.DaggerDebugAppComponent
import com.gurpreetsk.android_starter.di.modules.AppModule

class DebugMainApplication : MainApplication() {
  override fun onCreate() {
    super.onCreate()

    Stetho.initializeWithDefaults(this)
  }

  override fun getAppComponent(): AppComponent {
    return DaggerDebugAppComponent.builder()
        .appModule(AppModule(this))
        .build()
  }
}
