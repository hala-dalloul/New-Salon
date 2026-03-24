package com.example.newsalon.presentation.navigation

sealed class Screen(val route: String){
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")
    object ProfileScreen : Screen("profile")
    object CategoryScreen : Screen("category")
    object CartScreen : Screen("cart")
    object FavoriteScreen : Screen("favorite")

}