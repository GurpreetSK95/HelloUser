package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviLifecycle
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Test

class GreetingModelTest {
    private val lifecycle = PublishRelay.create<MviLifecycle>()
    private val typingIntention = PublishRelay.create<String>()

    private val observer by lazy {
        GreetingModel
                .bind(lifecycle, typingIntention)
                .test()
    }

    @Test
    fun `emit initial state on lifecycle created`() {
        lifecycle.accept(MviLifecycle.CREATED)

        observer.assertValues(GreetingState(""))
    }

    @Test
    fun `greet user when input is not empty`() {
        lifecycle.accept(MviLifecycle.CREATED)
        typingIntention.accept("G")
        typingIntention.accept("Gu")
        typingIntention.accept("Gur")

        observer.assertValues(
                GreetingState(""),
                GreetingState("G"),
                GreetingState("Gu"),
                GreetingState("Gur")
        )
    }

    @Test
    fun `greet unknown user when input is empty`() {
        lifecycle.accept(MviLifecycle.CREATED)
        typingIntention.accept("G")
        typingIntention.accept("")

        observer.assertValues(
                GreetingState(""),
                GreetingState("G"),
                GreetingState("")
        )
    }

    @After
    fun teardown() {
        observer
                .assertNoErrors()
                .assertNotTerminated()
    }
}
