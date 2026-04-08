package com.example.newsalon.data.repository

import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo

class ProductRepoImp : ProductRepo {
    override fun getProductById(productId: Int): Product? {
        return FakeData.products.find { it.id == productId }
    }

    override fun toggleFavorite(productId: Int) {
        val index = FakeData.products.indexOfFirst { it.id == productId }
        if(index != -1){
            val currentProduct = FakeData.products[index]
            FakeData.products[index] = currentProduct.copy(isLove = !currentProduct.isLove)
        }
    }
    override fun getFavoriteProducts(): List<Product> {
        return FakeData.products.filter { it.isLove }
    }
}