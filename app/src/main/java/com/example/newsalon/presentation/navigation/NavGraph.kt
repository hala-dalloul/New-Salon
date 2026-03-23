package com.example.newsalon.presentation.navigation

import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsalon.presentation.screens.auth.LoginScreen
import com.example.newsalon.presentation.screens.home.HomeScreen
import com.example.newsalon.presentation.screens.profile.ProfileScreen


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