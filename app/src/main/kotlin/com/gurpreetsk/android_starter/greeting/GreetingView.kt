package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviView
import com.gurpreetsk.android_starter.storage.common.empty

interface GreetingView : MviView<GreetingState> {
    fun renderUnknownGreeting()
    fun greetUser(name: String)

    override fun render(state: GreetingState) {
        when (val input = state.input) {
            String.empty() -> renderUnknownGreeting()

            else -> greetUser(input)
        }
    }
}
