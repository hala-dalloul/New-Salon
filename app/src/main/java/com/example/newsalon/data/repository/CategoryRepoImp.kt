package com.example.newsalon.data.repository

import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Category
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.CategoryRepo

class CategoryRepoImp(): CategoryRepo {
    override fun getAllCategories(): List<Category> = FakeData.categories

    override fun getProductsByCategory(categoryId: String): List<Product> {
        return FakeData.products.filter { it.category == categoryId }
    }

}