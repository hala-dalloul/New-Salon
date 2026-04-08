package com.example.newsalon.presentation.screens.favorite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo
import com.example.newsalon.data.repository.ProductRepoImp

class FavoriteViewModel(
    private val productRepo: ProductRepo = ProductRepoImp()
) : ViewModel() {

    private val _favoriteProducts = mutableStateListOf<Product>()
    val favoriteProducts: List<Product> get() = _favoriteProducts

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        _favoriteProducts.clear()
        _favoriteProducts.addAll(productRepo.getFavoriteProducts())
    }

    fun toggleFavorite(product: Product) {
        productRepo.toggleFavorite(product.id)
        // Refresh the list after toggling
        loadFavorites()
    }
}