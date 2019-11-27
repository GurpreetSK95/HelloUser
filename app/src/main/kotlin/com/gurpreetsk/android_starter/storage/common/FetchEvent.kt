package com.gurpreetsk.android_starter.storage.common

data class FetchEvent<out T>(
    val fetchAction: FetchAction,
    val result: T?,
    val errors: List<ApplicationError> = emptyList()
)
