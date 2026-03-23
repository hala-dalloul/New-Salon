package com.example.newsalon.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newsalon.presentation.theme.BeautyRed

@Composable
fun BottomNavigationBar(
    items: List<NavItem>,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onClickLis: (NavItem) -> Unit
) {

    val backStack by navController.currentBackStackEntryAsState()

    NavigationBar(modifier.fillMaxWidth(),Color(0x00F6F6F6), tonalElevation = 0.dp) {
        items.forEach { item->
            val selected = item.rout == backStack?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onClickLis(item) },
                alwaysShowLabel = false,
                label = null,
                icon = {
                    BadgedBox(badge = {
                        val isCartPage = item.rout == Screen.CartScreen.route
                        if (item.budgeCount > 0 && !(selected && isCartPage) )
                            Badge (containerColor = BeautyRed, contentColor = Color.White)
                            { Text(item.budgeCount.toString()) }
                    }) {
                        Icon(item.icon, contentDescription = item.name)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BeautyRed,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }

}