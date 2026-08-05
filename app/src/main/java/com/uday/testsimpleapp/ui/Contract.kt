package com.uday.testsimpleapp.ui

import com.uday.testsimpleapp.data.User

sealed class UserIntent {
    object FetchUsers : UserIntent()
}

data class UiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)

sealed class Effects {
    class ShowToast(val text: String) : Effects()
    object NavigateToDetails : Effects()
}