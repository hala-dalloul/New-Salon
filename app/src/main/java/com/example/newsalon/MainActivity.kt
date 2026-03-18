package com.example.newsalon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.newsalon.presentation.screens.auth.LoginScreen
import com.example.newsalon.presentation.theme.BeautyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeautyAppTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {

}