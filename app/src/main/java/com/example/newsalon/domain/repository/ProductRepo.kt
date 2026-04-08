package com.example.newsalon.domain.repository

import com.example.newsalon.domain.models.Product

interface ProductRepo {
    fun getProductById(productId: Int): Product?
    fun toggleFavorite(productId: Int)
}