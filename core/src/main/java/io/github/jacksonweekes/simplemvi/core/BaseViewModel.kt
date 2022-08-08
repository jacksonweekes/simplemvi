package io.github.jacksonweekes.simplemvi.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<VS: ViewState, I: Intent, E: Effect>(initialState: VS,
                                                                  private val reducer: StateReducer<VS, E>
) {

    private val _viewState = MutableStateFlow(initialState)
    val viewState = _viewState.asStateFlow()

    protected fun applyEffect(effect: E) {
        _viewState.update { viewState ->
            reducer.reduce(viewState, effect)
        }
    }

    abstract fun onIntent(intent: I)
}