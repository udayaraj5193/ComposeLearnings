package com.uday.testsimpleapp.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            UserListScreen(onUserClick = { userName ->
                navController.navigate("details/$userName")
            })
        }
        composable("details/{userName}") { backStackEntry ->
            DetailsScreen(backStackEntry.arguments?.getString("userName"))
        }
    }
}