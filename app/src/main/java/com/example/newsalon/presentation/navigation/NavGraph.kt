package com.example.newsalon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsalon.presentation.screens.auth.LoginScreen
import com.example.newsalon.presentation.screens.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
       navController,startDestination = Screen.LoginScreen.route
    ){
        composable(Screen.LoginScreen.route){
            LoginScreen(
                onSuccess = {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.LoginScreen.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.ProfileScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.CategoryScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.CartScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.FavoriteScreen.route){
            HomeScreen(navController)
        }

    }
}