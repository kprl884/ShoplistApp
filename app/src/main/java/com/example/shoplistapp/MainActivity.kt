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
import com.example.shoplistapp.presentation.product.HomeScreen
import com.example.shoplistapp.presentation.product.HomeScreenViewModel
import com.example.shoplistapp.presentation.shoppingitem.ShoppingItemScreen
import com.example.shoplistapp.presentation.shoppingitem.ShoppingScreenViewModel
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
                darkTheme = true
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val shoppingScreenViewModel: ShoppingScreenViewModel by viewModels()
                    val productScreenViewModel: HomeScreenViewModel by viewModels()
                    NavHost(navController = navController, startDestination = "product") {
                        composable("shopping") {
                            ShoppingItemScreen(
                                shoppingScreenViewModel.uiState,
                                onEvent = {
                                    shoppingScreenViewModel.onEvent(it)
                                }
                            )
                        }
                        composable("product") {
                            HomeScreen(
                                productScreenViewModel.uiState
                            )
                        }
                    }
                }
            }
        }
    }
}