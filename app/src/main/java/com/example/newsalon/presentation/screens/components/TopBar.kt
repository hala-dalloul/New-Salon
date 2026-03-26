package com.example.newsalon.presentation.screens.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsalon.presentation.theme.BeautyDarkGray
import com.example.newsalon.presentation.theme.BeautyRed

@Composable
fun BeautyTopBar(
    text: String = "",
    textAlign: TextAlign = TextAlign.Start,
    isNotification: Boolean = false,
    isShowSearch : Boolean = false,
    isShowBackButton : Boolean = false,
    onBackClick: () -> Unit = {},
    isShowNotification : Boolean = false,
    current : Context = LocalContext.current
) {
    Row(
        Modifier.fillMaxWidth().padding(top = 45.dp, bottom = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        if(isShowBackButton){
            IconButton(onClick = {
                onBackClick()
            }, modifier = Modifier.size(40.dp).padding(start = 15.dp)) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Back",
                    tint = BeautyRed, modifier = Modifier.size(30.dp))
            }
        }
        Text(text, modifier = Modifier.fillMaxWidth(0.8f).padding(start = 20.dp), textAlign = textAlign, fontSize = 18.sp, fontWeight = FontWeight.W700)

        BadgedBox(
            modifier = Modifier.size(36.dp),
            badge = {
                if (isNotification) {
                    Badge(
                        containerColor = BeautyRed
                    )
                }
            }
        ) {
            if(isShowNotification){
                IconButton(onClick = {
                    Toast.makeText(current, "Notification", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier.size(36.dp)) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notification",
                        tint = BeautyDarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }

        if(isShowSearch){
            IconButton(onClick = {
                Toast.makeText(current, "Search", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.size(36.dp)) {
                Icon(
                    Icons.Default.Search, "Search",
                    tint = BeautyDarkGray, modifier = Modifier.size(30.dp))
            }
        }

    }
}
@Preview
@Composable
fun BeautyTopBarPreview() {
    BeautyTopBar(text="good morning", isShowNotification = true, textAlign = TextAlign.Center)
}
