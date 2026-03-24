package com.example.newsalon.domain.models

data class User (
    val id: Int,
    val phone: String ="",
    val name: String ="",
    val email: String,
    val image: String
)