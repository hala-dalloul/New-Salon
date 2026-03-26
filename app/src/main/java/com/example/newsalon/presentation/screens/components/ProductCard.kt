package com.example.newsalon.presentation.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Product
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyDarkGray
import com.example.newsalon.presentation.theme.BeautyRed

@SuppressLint("ResourceAsColor")
@Composable
fun ProductCard(product: Product) {
    BeautyAppTheme {
        Card(Modifier
            .padding(end = 5.dp, top = 17.dp)
            .fillMaxWidth(0.4f)
            .fillMaxHeight(0.01f)) {
            Column(Modifier
                .fillMaxSize()
                .background(Color.White)) {
                Box(Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .background(Color(0xffFFF6F9))) {
                    Image(
                        painter =
                            painterResource((product.image).toInt()),
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                            product.isLove =
                                !product.isLove
                        },
                        Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                            .size(35.dp)
                            .align(Alignment.TopEnd)
                            .padding(5.dp)
                    ) {
                        if (product.isLove) {
                            Icon(
                                 Icons.Default.Favorite,
                                contentDescription = "Love this product",
                                tint = colorResource(id = R.color.BeautyRed)
                                )
                        } else {
                            Icon(
                                Icons.Default.FavoriteBorder,
                                contentDescription = "Love this product",
                                tint = colorResource(id = R.color.BeautyRed)
                            )
                        }
                    }
                }
                Column(Modifier
                    .padding(start = 12.dp, top = 10.dp)
                    .fillMaxWidth()) {
                    Text(if(product.name.length < 20){ product.name }else{ "${product.name.substring(0,21)}..." }, fontWeight = FontWeight.W400, fontSize = 12.sp)

                    val categoryName = FakeData.categories.find { it.id.toString() == product.category }?.name ?: ""
                    
                    Text(categoryName, fontSize = 12.sp, fontWeight = FontWeight.W500)
                    Row(Modifier.fillMaxWidth()) {
                        if(product.discount == 0.0){
                            Text("$${(product.price)}", fontSize = 15.sp, color = BeautyRed)
                        }else{
                            Text("$${product.price}",fontSize = 12.sp, color = BeautyDarkGray, textDecoration = TextDecoration.LineThrough, fontWeight = FontWeight.W400)
                            Text("  $${(product.price * product.discount)}",fontSize = 15.sp, color = BeautyRed, fontWeight = FontWeight.W600)
                        }
                        Text("${product.count} sold",modifier = Modifier.fillMaxWidth().padding(end = 12.dp), fontSize = 10.sp, fontWeight = FontWeight.W400, textAlign = TextAlign.End)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Product() {
    BeautyAppTheme {
        ProductCard(FakeData.products[1])

    }
}