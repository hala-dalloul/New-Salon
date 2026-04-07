package com.example.newsalon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsalon.presentation.screens.auth.LoginScreen
import com.example.newsalon.presentation.screens.category.CategoryScreen
import com.example.newsalon.presentation.screens.cart.CartScreen
import com.example.newsalon.presentation.screens.category.CategoryProductsScreen
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
            ProfileScreen(navController)
        }
        composable(Screen.CategoryScreen.route){
            CategoryScreen(navController)
        }

        composable("category_details_screen/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            CategoryProductsScreen(navController, categoryId)
        }

        composable(Screen.CartScreen.route){
            CartScreen(navController)
        }
        composable(Screen.FavoriteScreen.route){
            HomeScreen(navController)
        }

    }
}