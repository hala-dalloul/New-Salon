package com.example.newsalon.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.R
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.domain.models.Category
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyDarkGray
import com.example.newsalon.presentation.theme.BeautyOfWhite


@Composable
fun CategoryCard(category: Category , navController: NavHostController) {
    BeautyAppTheme {
        Box(
            Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xffFFF6F9))
                .fillMaxWidth(0.45f)
                .height(164.dp)
                .clickable(
                    enabled = true, onClickLabel = category.name,
                    onClick = {
                        navController.navigate("category_details_screen/${category.id}")
                    })

        ) {
            Image(
                painter = painterResource((category.image).toInt()),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient
                            (
                            listOf(
                                Color(0x00000000),
                                Color(0x66000000)
                            )
                        )
                    )
            )
            Text(
                category.name,
                color = BeautyOfWhite,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategory() {
    BeautyAppTheme {
        CategoryCard(
            FakeData.categories[1], rememberNavController()
        )
    }
}