package com.uday.testsimpleapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uday.testsimpleapp.data.User
import com.uday.testsimpleapp.domain.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userUseCase: UserUseCase) : ViewModel() {

    val uiState = MutableStateFlow<UiState>(UiState.Loading)


    init {
        viewModelScope.launch {
            try {
                uiState.emit(UiState.Success(userUseCase()))
            } catch (e: Exception) {
                uiState.emit(UiState.Error("Error fetching users"))
            }
        }
    }


    sealed interface UiState {
        data class Success(val users: List<User>) : UiState
        data class Error(val message: String? = null) : UiState
        object Loading : UiState
    }
}