package com.example.newsalon.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.presentation.navigation.BottomNavigationBar
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.FeatureBanner
import com.example.newsalon.presentation.screens.components.ProductCard
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.domain.models.Product
import com.example.newsalon.presentation.navigation.NavItem
import com.example.newsalon.presentation.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items =listOf(
                    NavItem(Screen.HomeScreen.route, Icons.Default.Home, Screen.HomeScreen.route),
                    NavItem(Screen.CategoryScreen.route, ImageVector.vectorResource(R.drawable.icon_category), Screen.CategoryScreen.route),
                    NavItem(Screen.CartScreen.route, Icons.Default.ShoppingCart, Screen.CartScreen.route, budgeCount = 3),
                    NavItem(Screen.FavoriteScreen.route, Icons.Default.FavoriteBorder, Screen.FavoriteScreen.route),
                    NavItem(Screen.ProfileScreen.route, Icons.Default.Person, Screen.ProfileScreen.route),
                ),
                navController = navController,
                onClickLis = { item ->
                    navController.navigate(item.rout) {
                        popUpTo(Screen.HomeScreen.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        topBar = { BeautyTopBar(true,isShowNotification = true)},
        containerColor = Color.White
    ) { innerPadding->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // banner
            item{
                FeatureBanner()
            }

        }
    }
}
@Preview
@Composable
fun PreviewFun(){
    BeautyAppTheme {
        HomeScreen(rememberNavController())
    }
}