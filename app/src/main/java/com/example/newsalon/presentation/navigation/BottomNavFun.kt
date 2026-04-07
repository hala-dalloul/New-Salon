package com.example.newsalon.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData

@Composable
fun BottomNavFun (navController: NavHostController){
    BottomNavigationBar(
        items =listOf(
            NavItem(Screen.HomeScreen.route, Icons.Default.Home, Screen.HomeScreen.route),
            NavItem(Screen.CategoryScreen.route, ImageVector.vectorResource(R.drawable.icon_category), Screen.CategoryScreen.route),
            NavItem(Screen.CartScreen.route, Icons.Default.ShoppingCart, Screen.CartScreen.route, budgeCount = FakeData.cartItems.size),
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
        },
        modifier = Modifier.background(Color(0xffF6F6F6))
    )
    Spacer(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 15.dp)
            .height(1.dp)
            .fillMaxWidth()
            .border(2.dp, color = Color(0xffE3E3E3), shape = RoundedCornerShape(5.dp))
    )
}