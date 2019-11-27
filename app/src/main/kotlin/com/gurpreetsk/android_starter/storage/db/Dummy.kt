package com.gurpreetsk.android_starter.storage.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Dummy(
    @PrimaryKey(autoGenerate = true) val id: Long
)
