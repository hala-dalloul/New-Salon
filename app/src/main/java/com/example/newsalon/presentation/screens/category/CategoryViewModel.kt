package com.example.newsalon.presentation.screens.category

import androidx.lifecycle.ViewModel
import com.example.newsalon.data.repository.CategoryRepoImp
import com.example.newsalon.domain.models.Category
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.repository.CategoryRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoryUIState(
    val categories: List<Category> = emptyList(),
    val products: List<Product> = emptyList(),
    val isLoad: Boolean = false
)

class CategoryViewModel(
    private val repository: CategoryRepo = CategoryRepoImp()
): ViewModel(){
    private val _uiState = MutableStateFlow(CategoryUIState())
    val uiState: StateFlow<CategoryUIState> = _uiState.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        _uiState.update { it.copy(categories = repository.getAllCategories()) }
    }

    fun loadProducts(categoryId: String) {
        _uiState.update { it.copy(isLoad = true) }
        val products = repository.getProductsByCategory(categoryId)
        _uiState.update { it.copy(products = products, isLoad = false) }
    }
}