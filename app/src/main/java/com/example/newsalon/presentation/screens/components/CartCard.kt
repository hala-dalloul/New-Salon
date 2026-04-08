package com.example.newsalon.presentation.screens.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyRed

@Composable
fun CertCard(cartItem: CartItem, onDelete: () -> Unit, onQuantityChange: (Int) -> Unit) {
    val context = LocalContext.current
    BeautyAppTheme {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(173.dp)
                .height(265.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {
                Box(
                    Modifier
                        .height(128.dp)
                        .fillMaxWidth()
                        .background(Color(0xffFFF4F8))
                ) {
                    val imageId = cartItem.product.image.toIntOrNull() ?: R.drawable.image_creem
                    Image(
                        painter = painterResource(imageId),
                        contentDescription = cartItem.product.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier
                            .padding(top = 8.dp, end = 12.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(28.dp)
                            .align(Alignment.TopEnd)
                    ) {
                        Icon(
                            painterResource(R.drawable.icon_cancel),
                            contentDescription = "Cancel",
                            modifier = Modifier.size(12.dp),
                            tint = Color(0xffE10000)
                        )
                    }
                }
                
                Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                    Text(
                        text = if (cartItem.product.name.length < 20) {
                            cartItem.product.name
                        } else {
                            "${cartItem.product.name.take(18)}..."
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        maxLines = 1
                    )
                    
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "$${cartItem.product.price}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W600,
                            color = BeautyRed
                        )
                        
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = { if (cartItem.quantity > 1) onQuantityChange(cartItem.quantity - 1) },
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xffD69294))
                                    .size(22.dp)
                            ) {
                                Icon(
                                    painterResource(R.drawable.icon_minuse),
                                    contentDescription = "minus",
                                    tint = Color.White,
                                    modifier = Modifier.size(10.dp)
                                )
                            }

                            Text(
                                text = cartItem.quantity.toString().padStart(2, '0'),
                                modifier = Modifier.padding(horizontal = 6.dp),
                                fontWeight = FontWeight.W400,
                                fontSize = 13.sp
                            )
                            
                            IconButton(
                                onClick = { onQuantityChange(cartItem.quantity + 1) },
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xffBA484A))
                                    .size(22.dp),
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    tint = Color.White,
                                    contentDescription = "Add",
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }

                    Row(
                        Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = {
                                Toast.makeText(context, "Buy Now", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.height(30.dp),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                        ) {
                            Text(
                                "Buy Now",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = BeautyRed
                            )
                        }

                        IconButton(onClick = {}, modifier = Modifier.size(20.dp)) {
                            Icon(
                                Icons.Outlined.Info,
                                contentDescription = "Product Info",
                                tint = Color(0xff666666),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCartCard() {
    BeautyAppTheme {
        CertCard(FakeData.cartItems[1], {}, {})
    }
}
