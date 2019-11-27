package com.gurpreetsk.android_starter.di.modules

import android.content.Context
import androidx.room.Room
import com.gurpreetsk.android_starter.BuildConfig.DB_NAME
import com.gurpreetsk.android_starter.storage.Repository
import com.gurpreetsk.android_starter.storage.db.AppDatabase
import com.gurpreetsk.android_starter.storage.prefs.AppSettings
import com.gurpreetsk.android_starter.storage.RepositoryImpl
import com.gurpreetsk.android_starter.storage.prefs.SharedPreferencesAppSettings
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module object StorageModule {
  @JvmStatic @Provides @Singleton
  fun provideAppDatabase(context: Context): AppDatabase =
      Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()

  @JvmStatic @Provides @Singleton
  fun appSettings(context: Context): AppSettings =
      SharedPreferencesAppSettings(context)

  @JvmStatic @Provides @Singleton
  fun repository(): Repository =
      RepositoryImpl()
}
