package com.uday.testsimpleapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uday.testsimpleapp.domain.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    val uiState = MutableStateFlow<UiState>(UiState())
    val effects = MutableSharedFlow<Effects>()

    fun handleIntent(intent: UserIntent) {
        uiState.update { currentState -> currentState.copy(isLoading = true) }

        when (intent) {
            UserIntent.FetchUsers -> viewModelScope.launch {
                try {
                    val modified = userUseCase().map {
                        it.copy(imgUrl = "https://picsum.photos/200")
                    }

                    uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false, users = modified
                        )
                    }

                    effects.emit(Effects.ShowToast("Data fetched successfully"))

                } catch (e: Exception) {
                    uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false, error = "Something went wrong"
                        )
                    }
                }
            }
        }
    }
}