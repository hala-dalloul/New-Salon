package com.example.newsalon.presentation.screens.cart

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.CartItem

class CartViewModel : ViewModel() {
    val cartItems = FakeData.cartItems

    val subTotal: Double
        get() = cartItems.sumOf { it.product.price * it.quantity }

    fun updateQuantity(item: CartItem, newQuantity: Int) {
        val index = cartItems.indexOf(item)
        if (index != -1 && newQuantity > 0) {
            cartItems[index] = item.copy(quantity = newQuantity)
        }
    }

    fun removeItem(item: CartItem) {
        cartItems.remove(item)
    }
}