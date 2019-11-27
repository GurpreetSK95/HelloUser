package com.gurpreetsk.android_starter.storage.db

import androidx.room.Dao
import androidx.room.Insert

@Dao interface DummyDao {
  @Insert fun insert(user: Dummy)
}
