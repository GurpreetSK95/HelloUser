package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviLifecycle
import com.jakewharton.rxrelay2.PublishRelay
import org.junit.Test

class GreetingModelTest {
    @Test
    fun `emit initial state on lifecycle created`() {
        val lifecycle = PublishRelay.create<MviLifecycle>()

        val observer = GreetingModel
                .bind(lifecycle)
                .test()

        lifecycle.accept(MviLifecycle.CREATED)

        observer
                .assertNoErrors()
                .assertValues(GreetingState(""))
                .assertNotTerminated()
    }
}
