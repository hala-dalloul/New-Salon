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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
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
fun HomeScreen(navController: NavController) {
    Scaffold(

        topBar = { BeautyTopBar(true,isShowNotification = true)},
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