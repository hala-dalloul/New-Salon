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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.ProductCard
import com.example.newsalon.presentation.theme.BeautyAppTheme

@Composable
fun CategoryProductsScreen(navController: NavHostController, categoryId: String?, viewModel: CategoryViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(categoryId) {
        categoryId?.let{
            viewModel.loadProducts(it)
        }
    }

    val categoryName = FakeData.categories.find { it.id == categoryId }?.name ?: ""

    LaunchedEffect(uiState.products, uiState.isLoad) {
        if (uiState.products.isEmpty() && !uiState.isLoad && categoryId != null) {
            snackBarHostState.showSnackbar("No products in this category")
        }
    }

    BeautyAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { BeautyTopBar(text = categoryName, textAlign = TextAlign.Center, isShowBackButton = true, onBackClick = {navController.popBackStack()}) },
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
                    items(uiState.products) { product ->
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
        CategoryProductsScreen(rememberNavController(), (FakeData.categories[4].id).toString())
    }
}
