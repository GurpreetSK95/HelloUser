package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviLifecycle
import com.jakewharton.rxrelay2.PublishRelay
import org.junit.Test

class GreetingModelTest {
    @Test
    fun `emit initial state on lifecycle created`() {
        val lifecycle = PublishRelay.create<MviLifecycle>()
        val typingIntention = PublishRelay.create<String>()

        val observer = GreetingModel
                .bind(lifecycle, typingIntention)
                .test()

        lifecycle.accept(MviLifecycle.CREATED)

        observer
                .assertNoErrors()
                .assertValues(GreetingState(""))
                .assertNotTerminated()
    }

    @Test
    fun `greet user when input is not empty`() {
        val lifecycle = PublishRelay.create<MviLifecycle>()
        val typingIntention = PublishRelay.create<String>()

        val observer = GreetingModel
                .bind(lifecycle, typingIntention)
                .test()

        lifecycle.accept(MviLifecycle.CREATED)
        typingIntention.accept("G")
        typingIntention.accept("Gu")
        typingIntention.accept("Gur")

        observer
                .assertNoErrors()
                .assertValues(
                        GreetingState(""),
                        GreetingState("G"),
                        GreetingState("Gu"),
                        GreetingState("Gur")
                )
                .assertNotTerminated()
    }

    @Test
    fun `greet unknown user when input is empty`() {
        val lifecycle = PublishRelay.create<MviLifecycle>()
        val typingIntention = PublishRelay.create<String>()

        val observer = GreetingModel
                .bind(lifecycle, typingIntention)
                .test()

        lifecycle.accept(MviLifecycle.CREATED)
        typingIntention.accept("G")
        typingIntention.accept("")

        observer
                .assertNoErrors()
                .assertValues(
                        GreetingState(""),
                        GreetingState("G"),
                        GreetingState("")
                )
                .assertNotTerminated()
    }
}
