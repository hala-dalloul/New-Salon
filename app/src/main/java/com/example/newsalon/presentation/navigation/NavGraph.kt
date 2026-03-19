package com.example.newsalon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsalon.presentation.screens.auth.LoginScreen
import com.example.newsalon.presentation.screens.home.HomeScreen

sealed class Screen(val route: String){
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
       navController,startDestination = Screen.LoginScreen.route
    ){
        composable(Screen.LoginScreen.route){
            LoginScreen(
                onSuccess = {
                    println("System button clicked")
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
        }
        composable(Screen.HomeScreen.route){
            HomeScreen()
        }

    }
}