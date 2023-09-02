package com.example.shoplistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoplistapp.presentation.home.HomeScreen
import com.example.shoplistapp.presentation.home.HomeScreenViewModel
import com.example.shoplistapp.presentation.basket.BasketScreen
import com.example.shoplistapp.presentation.basket.BasketScreenViewModel
import com.example.shoplistapp.ui.theme.ShoplistAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalTextApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoplistAppTheme(
                darkTheme = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val basketScreenViewModel: BasketScreenViewModel by viewModels()
                    val homeScreenViewModel: HomeScreenViewModel by viewModels()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("basket") {
                            BasketScreen(
                                basketScreenViewModel.uiState
                            )
                        }
                        composable("home") {
                            HomeScreen(
                                homeScreenViewModel.uiState,
                                onEvent = {
                                    homeScreenViewModel.onEvent(it)
                                },
                                navigate = { navController.navigate("basket") }
                            )
                        }
                    }
                }
            }
        }
    }
}