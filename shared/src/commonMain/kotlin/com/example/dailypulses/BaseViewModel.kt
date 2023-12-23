package com.example.dailypulses

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope:CoroutineScope
}