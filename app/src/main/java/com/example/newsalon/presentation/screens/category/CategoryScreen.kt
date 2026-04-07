package com.example.newsalon.presentation.screens.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.navigation.BottomNavigationBar
import com.example.newsalon.presentation.navigation.NavItem
import com.example.newsalon.presentation.navigation.Screen
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.CategoryCard
import com.example.newsalon.presentation.theme.BeautyAppTheme


@Composable
fun CategoryScreen(navController: NavHostController, viewModel: CategoryViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    BeautyAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                BeautyTopBar(
                    text = "Category",
                    textAlign = TextAlign.Center,
                    isShowSearch = true
                )
            },
            bottomBar = {
                BottomNavFun(navController)
            }
        ) { innerPadding ->
            Column(Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                val state = rememberLazyGridState(1)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = state,
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 25.dp)
                        .fillMaxWidth()
                        .height(576.dp)
                ) {
                    val list = uiState.categories
                    items(count = list.size) { item ->
                        CategoryCard(list[item], navController = navController)
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun PreviewCategoryScreen() {
    BeautyAppTheme {
        CategoryScreen(rememberNavController())
    }
}