package com.example.newsalon.presentation.screens.cart

import androidx.lifecycle.ViewModel
import com.example.newsalon.data.repository.CartRepoImp
import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.domain.repository.CartRepo

class CartViewModel(
    private val cartRepo: CartRepo = CartRepoImp()
) : ViewModel() {

    val cartItems: List<CartItem>
        get() = cartRepo.getCartItems()

    val subTotal: Double
        get() = cartRepo.getSubTotal()

    fun updateQuantity(item: CartItem, newQuantity: Int) {
        cartRepo.updateQuantity(item.product.id, newQuantity)
    }

    fun removeItem(item: CartItem) {
        cartRepo.removeItem(item.product.id)
    }
}