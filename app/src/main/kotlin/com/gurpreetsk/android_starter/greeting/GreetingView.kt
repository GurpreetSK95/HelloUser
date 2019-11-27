package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.base.MviView

interface GreetingView : MviView<GreetingState> {
    fun renderUnknownGreeting()

    override fun render(state: GreetingState) {
        renderUnknownGreeting()
    }
}
