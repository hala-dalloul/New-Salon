package com.example.newsalon.data.repository

import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.domain.repository.CartRepo

class CartRepoImp : CartRepo {
    override fun getCartItems(): List<CartItem> {
        return FakeData.cartItems
    }

    override fun updateQuantity(productId: Int, newQuantity: Int) {
        val index = FakeData.cartItems.indexOfFirst { it.product.id == productId }
        if (index != -1 && newQuantity > 0) {
            FakeData.cartItems[index] = FakeData.cartItems[index].copy(quantity = newQuantity)
        }
    }

    override fun removeItem(productId: Int) {
        FakeData.cartItems.removeAll { it.product.id == productId }
    }

    override fun getSubTotal(): Double {
        return FakeData.cartItems.sumOf { it.product.price * it.quantity }
    }
}