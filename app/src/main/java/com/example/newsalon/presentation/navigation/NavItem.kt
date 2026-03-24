package com.example.newsalon.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val name: String,
    val icon: ImageVector,
    val rout: String,
    val budgeCount: Int = 0
)