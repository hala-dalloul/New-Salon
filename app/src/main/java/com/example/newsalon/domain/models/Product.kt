package com.example.newsalon.domain.models

data class Product (
    val id: Int,
    val name: String,
    val price: Double,
    val image: String,
    val description: String,
    val category: String,
    val isLove: Boolean
    )