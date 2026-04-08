package com.example.newsalon.presentation.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Product
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyDarkGray
import com.example.newsalon.presentation.theme.BeautyRed

@SuppressLint("ResourceAsColor")
@Composable
fun ProductCard(
    product: Product, 
    navController: NavHostController,
    onFavoriteClick: () -> Unit = {}
) {
    var isLoved by remember(product.isLove) { mutableStateOf(product.isLove) }

    BeautyAppTheme {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate("product_details_screen/${product.id}")
                },
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color(0xffFFF6F9))
                ) {
                    val imageRes = product.image.toIntOrNull() ?: R.drawable.image_creem
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                            isLoved = !isLoved
                            onFavoriteClick()
                        },
                        Modifier
                            .padding(8.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                            .align(Alignment.TopEnd)
                    ) {
                        Icon(
                            imageVector = if (isLoved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Love this product",
                            tint = BeautyRed,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column(
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = if (product.name.length < 20) product.name else "${product.name.take(20)}...",
                        fontWeight = FontWeight.W400,
                        fontSize = 13.sp,
                        maxLines = 1
                    )

                    val categoryName = FakeData.categories.find { it.id == product.category }?.name ?: ""
                    Text(categoryName, fontSize = 11.sp, color = Color.Gray)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (product.discount == 0.0) {
                            Text("$${product.price.toInt()}", fontSize = 15.sp, color = BeautyRed, fontWeight = FontWeight.Bold)
                        } else {
                            Row {
                                Text(
                                    "$${product.price.toInt()}",
                                    fontSize = 12.sp,
                                    color = BeautyDarkGray,
                                    textDecoration = TextDecoration.LineThrough
                                )
                                Text(
                                    "  $${(product.price * (1 - product.discount)).toInt()}",
                                    fontSize = 15.sp,
                                    color = BeautyRed,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Text(
                            "${product.count} sold",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    BeautyAppTheme {
        ProductCard(FakeData.products[0], rememberNavController())
    }
}