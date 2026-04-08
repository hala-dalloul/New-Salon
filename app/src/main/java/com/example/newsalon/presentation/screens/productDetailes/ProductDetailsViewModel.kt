package com.example.newsalon.presentation.screens.productDetailes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo
import com.example.newsalon.data.repository.ProductRepoImp

class ProductDetailsViewModel(
    private val productRepo: ProductRepo = ProductRepoImp()
) : ViewModel() {

    var productState by mutableStateOf<Product?>(null)
        private set

    var quantity by mutableIntStateOf(1)
        private set

    var isFavorite by mutableStateOf(false)
        private set

    fun loadProduct(productId: Int) {
        val product = productRepo.getProductById(productId)
        productState = product
        isFavorite = product?.isLove ?: false
    }

    fun incrementQuantity() {
        quantity++
    }

    fun decrementQuantity() {
        if (quantity > 1) quantity--
    }

    fun toggleFavorite() {
        productState?.let {
            productRepo.toggleFavorite(it.id)
            isFavorite = !isFavorite
        }
    }
}