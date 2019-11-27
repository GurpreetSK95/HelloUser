package com.gurpreetsk.android_starter.greeting

open class SpyableGreetingView : GreetingView {
    override fun renderUnknownGreeting() {}
    override fun greetUser(name: String) {}
}
