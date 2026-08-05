package com.uday.testsimpleapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.uday.testsimpleapp.data.User
import com.uday.testsimpleapp.ui.Effects
import com.uday.testsimpleapp.ui.UserIntent
import com.uday.testsimpleapp.ui.UserViewModel

@Composable
fun UserListScreen(onUserClick: (String) -> Unit) {
    val userViewModel: UserViewModel = hiltViewModel()
    val state by userViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when {
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(60.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        state.users.isNotEmpty() -> {
            LazyColumn {
                items(state.users.size) { index ->
                    ListItem(user = state.users[index]) { name ->
                        onUserClick(name)
                    }
                }
            }
        }

        state.error != null -> {
            Text(text = state.error.orEmpty())
        }

    }
    LaunchedEffect(Unit) {
        userViewModel.handleIntent(UserIntent.FetchUsers)
    }
    LaunchedEffect(Unit) {
        userViewModel.effects.collect { effect ->
            when (effect) {
                is Effects.ShowToast -> {
                    Toast.makeText(
                        context,
                        effect.text,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                is Effects.NavigateToDetails -> {}
            }
        }

    }
}

@Composable
fun ListItem(user: User, listener: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                listener.invoke(user.name)
            }
    ) {
        AsyncImage(
            model = user.imgUrl, contentDescription = null, modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Column() {
            Text(text = user.name)
            Text(text = user.phone)
            Text(text = user.email)

        }


    }

}

@Preview(showBackground = true)
@Composable
fun ListItemP() {
    Row() {
        AsyncImage(
            model = "https://picsum.photos/200",
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Column() {
            Text(text = "user.name")
            Text(text = "user.phone")
            Text(text = "user.email")

        }
    }
}