package com.example.newsalon.presentation.screens.auth

import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsalon.R

@Composable
fun LoginScreen() {
    var phoneNumber by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.BeautyOfWhite)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
               Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(R.drawable.image_girl),
                    contentDescription = "Beauty Girl",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.Crop // لجعل الصورة تملأ العرض بشكل جميل
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(30.dp)
                        .background
                            (
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, colorResource(R.color.BeautyOfWhite))
                            )
                        )
                )
            }

            Text(
                text = "Your Phone number",
                modifier = Modifier.padding(top = 15.dp, start = 16.dp),
                style = MaterialTheme.typography.labelMedium
            )
            
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = { Text("Enter Your Phone Number", fontSize = 12.sp, color = Color.Gray) },
                prefix = {
                    Text("+972 ",fontSize = 12.sp)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )
            TextButton(
                onClick = {
                    // add snack bar here
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
            ) {
                Text("Sing in with Email", textAlign = TextAlign.Center)
            }
            Button(onClick = {
                // go to home screen
            },
                modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), shape = RoundedCornerShape(6.dp)) {
                Text("Login")
            }

            val privacy = buildAnnotatedString{
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 13.sp)) {
                    append("By clicking login you agree to our")
                }

                pushStringAnnotation(tag = "Terms", annotation = "terms")
                withStyle(style = SpanStyle(color = Color(0xff1877F2), fontWeight = FontWeight.Bold, fontSize = 13.sp)) {
                    append(" terms & conditions")
                }
                pop()
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 13.sp)) {
                    append(" and ")
                }
                pushStringAnnotation(tag = "Privacy", annotation = "privacy")
                withStyle(style = SpanStyle(color = Color(0xff1877F2), fontWeight = FontWeight.Bold, fontSize = 13.sp)) {
                    append("privacy policy")
                }
                pop()
            }

            ClickableText(
                text = privacy,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 18.dp),
                onClick = { offset ->
                    privacy.getStringAnnotations(tag = "Terms", start = offset, end = offset)
                        .firstOrNull()?.let { annotation ->
                            println("( item ${annotation.item})")
                        }

                    privacy.getStringAnnotations(tag = "Privacy", start = offset, end = offset)
                        .firstOrNull()?.let { annotation ->
                            println("( item ${annotation.item})")
                        }
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.fillMaxWidth(0.46f).height(3.dp).background(Color.White))
                Text("OR", modifier = Modifier.padding(horizontal = 8.dp))
                Box(Modifier.fillMaxWidth(1f).height(3.dp).background(Color.White))
            }

            Row(
                modifier = Modifier.padding(top = 90.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                FilledIconButton(
                    onClick ={},
                    modifier = Modifier
                        .size(50.dp)
                        .padding(4.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Unspecified
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_google),
                        contentDescription = "google",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(12.dp)
                            .aspectRatio(1f)
                    )
                }
                FilledIconButton(
                    onClick ={},
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .size(50.dp)
                        .padding(2.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Unspecified
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.iconfacebook),
                        contentDescription = "facebook",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(12.dp)
                            .aspectRatio(1f)
                    )
                }
                FilledIconButton(
                    onClick ={},
                    modifier = Modifier
                        .size(50.dp)
                        .padding(4.dp),
                    shape = CircleShape,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Unspecified
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_twitter),
                        contentDescription = "twitter",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(12.dp)
                            .aspectRatio(1f)
                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        LoginScreen()
    }
}
