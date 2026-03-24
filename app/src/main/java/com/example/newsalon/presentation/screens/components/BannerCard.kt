package com.example.newsalon.presentation.screens.components

import android.R.attr.bottom
import android.R.attr.top
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.contentType
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsalon.R
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyRed
import com.example.newsalon.presentation.theme.Typography
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun BannerCard (){
    Card(
        Modifier
            .height(166.dp)
            .width(375.dp)
            .padding(horizontal = 5.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Box(Modifier.fillMaxSize()){
            Image(
                painterResource(R.drawable.image_lipsticks_set),
                contentDescription="Banner Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(top = 20.dp, start = 20.dp)
            ) {
                Text("Lipsticks sit", fontSize = 16.sp, style = Typography.labelMedium, fontWeight = FontWeight.W500)
                Text("10$", Modifier.padding(vertical = 10.dp), style = Typography.bodyLarge, color = BeautyRed, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Button(onClick = {},
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text("Shop Now", fontSize = 13.sp, fontWeight = FontWeight.W400)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard(){
    BeautyAppTheme {
        BannerCard()
    }
}