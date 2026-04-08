package com.example.newsalon.domain.repository

import com.example.newsalon.domain.models.CartItem

interface CartRepo {
    fun getCartItems(): List<CartItem>
    fun updateQuantity(productId: Int, newQuantity: Int)
    fun removeItem(productId: Int)
    fun getSubTotal(): Double
}