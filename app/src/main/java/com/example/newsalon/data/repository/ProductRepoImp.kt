package com.example.newsalon.data.repository

import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.ProductRepo

class ProductRepoImp : ProductRepo {
    override fun getProductById(productId: Int): Product? {
        return FakeData.products.find { it.id == productId }
    }

    override fun toggleFavorite(productId: Int) {
        FakeData.products.find { it.id == productId }?.let {
            it.isLove = !it.isLove
        }
    }
    override fun getFavoriteProducts(): List<Product> {
        return FakeData.products.filter { it.isLove }
    }
}