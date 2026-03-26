package com.example.newsalon.domain.models

data class Product (
    val id: Int,
    val name: String,
    val price: Double,
    val image: String,
    val description: String,
    val category: String,
    var isLove: Boolean,
    val discount: Double = 0.0,
    val count: Int = 0
    )