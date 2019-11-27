package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviLifecycle
import com.gurpreetsk.android_starter.storage.common.empty
import io.reactivex.Observable

object GreetingModel {
    fun bind(
            lifecycle: Observable<MviLifecycle>,
            typingIntention: Observable<String>
    ): Observable<GreetingState> {
        val lifecycleCreatedStates = lifecycle
                .filter { it == MviLifecycle.CREATED }
                .map { GreetingState(String.empty()) }

        val typingStates = typingIntention
                .map { GreetingState(it) }

        return Observable.merge(
                lifecycleCreatedStates,
                typingStates
        )
    }
}
