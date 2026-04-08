package com.example.newsalon.presentation.screens.favorite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo
import com.example.newsalon.data.repository.ProductRepoImp

class FavoriteViewModel(
    private val productRepo: ProductRepo = ProductRepoImp()
) : ViewModel() {

    val favoriteProducts: List<Product> get() = FakeData.products.filter { it.isLove }


    fun toggleFavorite(product: Product) {
        productRepo.toggleFavorite(product.id)
    }
}