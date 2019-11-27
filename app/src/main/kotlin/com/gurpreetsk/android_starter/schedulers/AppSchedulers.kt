package com.gurpreetsk.android_starter.schedulers

import io.reactivex.Scheduler

interface AppSchedulers {
  val computation: Scheduler
  val io: Scheduler
  val ui: Scheduler
}
