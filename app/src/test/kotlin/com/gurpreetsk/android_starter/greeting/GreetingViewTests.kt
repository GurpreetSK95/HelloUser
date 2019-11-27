package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.storage.common.empty
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GreetingViewTests {
    @Spy
    private lateinit var view: SpyableGreetingView

    @Test
    fun `greet unknown user when no name is input`() {
        view.render(GreetingState(String.empty()))

        verify(view).renderUnknownGreeting()
    }
}
