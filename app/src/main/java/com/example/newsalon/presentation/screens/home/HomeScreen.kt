package com.example.newsalon.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.navigation.BottomNavigationBar
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.FeatureBanner
import com.example.newsalon.presentation.screens.components.ProductCard
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.navigation.NavItem
import com.example.newsalon.presentation.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    val gridState = rememberLazyGridState(0)
    Scaffold(
        bottomBar = {
            BottomNavFun(navController)
        },
        topBar = { BeautyTopBar("Good Morning", isNotification = true,isShowNotification = true,isShowSearch = true)},
        containerColor = Color.White
    ) { innerPadding->
        Column(Modifier.fillMaxSize().padding(innerPadding)) {
            // banner
            FeatureBanner()
            // items
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 25.dp)
                    .fillMaxSize()
            ) {
                val list = FakeData.products
                items(count = list.size) { item ->
                    ProductCard(list[item])
                }
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