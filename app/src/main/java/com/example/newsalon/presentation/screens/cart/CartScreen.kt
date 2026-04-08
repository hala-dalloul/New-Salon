package com.example.newsalon.presentation.screens.cart

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.CertCard
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyRed
import java.util.Locale

@Composable
fun CartScreen(navController: NavHostController, viewModel: CartViewModel = viewModel()) {
    val context = LocalContext.current
    BeautyAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                BeautyTopBar(
                    text = "Cart(${viewModel.cartItems.size})",
                    textAlign = TextAlign.Center
                )
            },
            bottomBar = {
                BottomNavFun(navController)
            }
        ) { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                val state = rememberLazyGridState()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = state,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 15.dp, vertical = 20.dp)
                ) {
                    items(viewModel.cartItems) { item ->
                        CertCard(
                            cartItem = item,
                            onDelete = { viewModel.removeItem(item) },
                            onQuantityChange = { newQuantity ->
                                viewModel.updateQuantity(item, newQuantity)
                            }
                        )
                    }
                }
                
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xFFEEEEEE))
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("SubTotal", fontSize = 14.sp, color = Color.Gray)
                        Text(
                            text = "$${String.format(Locale.US, "%.2f", viewModel.subTotal)}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { Toast.makeText(context, "Proceeding to checkout", Toast.LENGTH_SHORT).show() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BeautyRed),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            "Buy now",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCartScreen() {
    BeautyAppTheme {
        CartScreen(rememberNavController())
    }
}
