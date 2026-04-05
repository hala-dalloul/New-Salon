package com.example.newsalon.domain.repository

import com.example.newsalon.domain.models.Category
import com.example.newsalon.domain.models.Product

interface CategoryRepo {
    fun getAllCategories():List<Category>
    fun getProductsByCategory(categoryId: String): List<Product>
}