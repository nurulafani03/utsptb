package com.lixoten.demonavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lixoten.demonavigation.ui.theme.DemoNavigationTheme

enum class AppDestinations(val title: String) {
    Start(title = "Start # One Screen"),
    ScreenTwo(title = "# Two Screen"),
    ScreenThree(title = "# Three Screen"),
    ScreenFour(title = "# Four Screen"),
    Last(title = "Last # Five Screen")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoApp()
                }
            }
        }
    }
}

@Composable
fun DemoApp() {
    DemoScreens()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoNavigationTheme {
        DemoApp()
    }
}