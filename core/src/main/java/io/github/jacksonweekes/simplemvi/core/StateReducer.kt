package io.github.jacksonweekes.simplemvi.core

abstract class StateReducer<VS: ViewState, E: Effect>() {
    abstract fun reduce(viewState: VS, effect: E): VS
}