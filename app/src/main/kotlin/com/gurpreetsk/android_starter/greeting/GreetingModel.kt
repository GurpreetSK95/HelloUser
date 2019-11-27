package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviLifecycle
import com.gurpreetsk.android_starter.storage.common.empty
import io.reactivex.Observable

object GreetingModel {
    fun bind(lifecycle: Observable<MviLifecycle>): Observable<GreetingState> {
        return lifecycle
                .filter { it == MviLifecycle.CREATED }
                .map { GreetingState(String.empty()) }
    }
}
