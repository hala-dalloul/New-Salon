package com.example.newsalon.presentation.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.theme.BeautyAppTheme


@Composable
fun FeatureBanner() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(FakeData.banners) { index, banner ->
            BannerCard()
        }
    }
}

@Preview
@Composable
fun preview(){
    BeautyAppTheme {
        FeatureBanner()
    }
}