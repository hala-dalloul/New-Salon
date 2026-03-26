package com.example.newsalon.presentation.screens.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.ProductCard
import com.example.newsalon.presentation.theme.BeautyAppTheme

@Composable
fun CategoryProductsScreen(navController: NavHostController, categoryId: String?) {
    val snackBarHostState = remember { SnackbarHostState() }
    val products = FakeData.products.filter { it.category == categoryId }
    val categoryName = FakeData.categories.find { it.id.toString() == categoryId }?.name ?: ""

    LaunchedEffect(products) {
        if (products.isEmpty()) {
            snackBarHostState.showSnackbar("No products in this category")
        }
    }

    BeautyAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { BeautyTopBar(text = categoryName, textAlign = TextAlign.Center, isShowBackButton = true) },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
        ) { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                val state = rememberLazyGridState()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = state,
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 25.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(products) { product ->
                        ProductCard(product)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCategory() {
    BeautyAppTheme {
        CategoryProductsScreen(rememberNavController(), (FakeData.categories[1].id).toString())
    }
}
