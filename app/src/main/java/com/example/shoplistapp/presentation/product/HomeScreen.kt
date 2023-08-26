package com.example.shoplistapp.presentation.product

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.components.productitem.ShoppingItemCard
import com.example.shoplistapp.domain.entity.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    uiStateFlow: StateFlow<HomeScreenUiState>
) {
    val uiState by uiStateFlow.collectAsState()
   
    LazyColumn() {
        item {
            if(uiState.productList.isNullOrEmpty()){
                Text(text = "Boş ürün")
            }else{
                Text(text = "Ürünlerim")
            }
        }
        uiState.productList?.let {
            items(it){productItem->
                ShoppingItemCard(productItem, {}, {})
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    HomeScreen(
        uiStateFlow = MutableStateFlow(
            HomeScreenUiState(
                false,
                listOf
                    (
                    ProductItem(1, "title", 1f, "ayakkabı", "sad", "sad"),
                    ProductItem(1, "title", 1f, "ayakkabı", "sad", "sad"),
                    ProductItem(1, "title", 1f, "ayakkabı", "sad", "sad")
                )
            )
        )
    )
}