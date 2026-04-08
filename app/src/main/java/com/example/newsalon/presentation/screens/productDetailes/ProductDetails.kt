package com.example.newsalon.presentation.screens.productDetailes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.presentation.navigation.Screen
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyRed
import java.util.Locale

@Composable
fun ProductDetails(
    navController: NavHostController,
    productId: Int,
    viewModel: ProductDetailsViewModel = viewModel()
) {
    val product = viewModel.productState

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    Scaffold(
        topBar = {
            BeautyTopBar(
                text = product?.name ?: "",
                isShowBackButton = true,
                onBackClick = { navController.popBackStack() },
                textAlign = TextAlign.Center
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .navigationBarsPadding(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /* Add to cart logic */ },
                        modifier = Modifier
                            .size(45.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    ) {
                        // Using a generic bag icon or a placeholder if icon_bag is missing
                        Icon(
                            Icons.Outlined.ShoppingCart,
                            contentDescription = "Add to cart",
                            tint = BeautyRed,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            viewModel.addToCart()
                            navController.navigate(Screen.CartScreen.route)
                                  },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BeautyRed),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Buy now", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.W600)
                    }
                }
            }
        }
    ) { paddingValues ->
        product?.let { currentProduct ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                // Product Image with Favorite Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color(0xFFF5F5F5))
                ) {
                    val imageRes = currentProduct.image.toIntOrNull() ?: R.drawable.image_creem
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Surface(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.TopEnd),
                        shape = CircleShape,
                        color = Color.White,
                        shadowElevation = 2.dp
                    ) {
                        IconButton(onClick = { viewModel.toggleFavorite() }) {
                            Icon(
                                imageVector = if (viewModel.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = BeautyRed
                            )
                        }
                    }
                }

                Column(modifier = Modifier.padding(24.dp)) {
                    // Price and Quantity
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$${String.format(Locale.US, "%.2f", currentProduct.price)}",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = { viewModel.decrementQuantity() },
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFDE8E8))
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.icon_minuse),
                                    contentDescription = "Decrease",
                                    tint = BeautyRed,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Text(
                                text = viewModel.quantity.toString().padStart(2, '0'),
                                modifier = Modifier.padding(horizontal = 12.dp),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                            IconButton(
                                onClick = { viewModel.incrementQuantity() },
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(BeautyRed)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Increase",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Rating and Orders
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFEEEEEE))
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFB400), modifier = Modifier.size(18.dp))
                            Text(text = " 4.8", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(text = " | 50 Orders", color = Color.Gray, fontSize = 14.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Gray)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Descriptio
                    Text(
                        text = currentProduct.description,
                        lineHeight = 24.sp,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }
            }
        } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = BeautyRed)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    BeautyAppTheme {
        ProductDetails(rememberNavController(), productId = 1)
    }
}