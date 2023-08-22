package com.example.shoplistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoplistapp.presentation.product.ProductScreen
import com.example.shoplistapp.presentation.shoppingitem.ShoppingItemScreen
import com.example.shoplistapp.ui.theme.ShoplistAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoplistAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "product") {
                        composable("shopping") { ShoppingItemScreen() }
                        composable("product") { ProductScreen() }
                    }
                }
            }
        }
    }
}