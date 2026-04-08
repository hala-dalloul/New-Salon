package com.example.newsalon.domain.repository

import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.domain.models.Product

interface CartRepo {
    fun getCartItems(): List<CartItem>
    fun updateQuantity(productId: Int, newQuantity: Int)
    fun removeItem(productId: Int)
    fun getSubTotal(): Double
    fun addToCart(product: Product, quantity: Int)
}