package com.example.newsalon.presentation.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.data.repository.ProductRepoImp
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo

class HomeViewModel(
    private val productRepo: ProductRepo = ProductRepoImp()
) : ViewModel() {

    private val _products = mutableStateListOf<Product>()
    val products: List<Product> get() = _products

    init {
        loadProducts()
    }

    fun loadProducts() {
        _products.clear()
        _products.addAll(FakeData.products)
    }

    fun toggleFavorite(product: Product) {
        productRepo.toggleFavorite(product.id)

        val index = _products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            _products[index] = _products[index].copy(isLove = !_products[index].isLove)
        }
    }
}