package com.uday.testsimpleapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uday.testsimpleapp.data.FakeDataSource
import com.uday.testsimpleapp.data.User
import com.uday.testsimpleapp.data.UserRepoImpl
import com.uday.testsimpleapp.domain.UserUseCase
import com.uday.testsimpleapp.ui.theme.TestSimpleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = FakeDataSource()

        val repository = UserRepoImpl(dataSource)

        val useCase = UserUseCase(repository)

        val viewModel = UserViewModel(useCase)

        enableEdgeToEdge()
        setContent {
            TestSimpleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        UserList(viewModel)
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun UserList(userViewModel: UserViewModel) {
        val state by userViewModel.uiState.collectAsState()

        when (state) {
            is UserViewModel.UiState.Success -> {
                val users = (state as UserViewModel.UiState.Success).users
                LazyColumn {
                    items(users.size) { index ->
                        ListItem(user = users[index])
                    }
                }
            }

            is UserViewModel.UiState.Error -> {
                val message = (state as UserViewModel.UiState.Error).message
                Text(text = message ?: "Unknown error")
            }

            UserViewModel.UiState.Loading -> {
                Text(text = "Loading...")
            }
        }
    }


    @Composable
    fun ListItem(user: User) {
        Column() {
            Text(text = user.name)
            Text(text = user.phone)
            Text(text = user.email)

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TestSimpleAppTheme {
            Greeting("Android")
        }
    }
}