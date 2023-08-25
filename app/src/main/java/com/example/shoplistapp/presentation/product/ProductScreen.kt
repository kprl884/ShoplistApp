package com.example.shoplistapp.presentation.product

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.components.productitem.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ProductScreen(
    uiStateFlow: StateFlow<ProductScreenUiState>
) {
    LazyColumn() {
        item {
            Text(text = "Ürünlerim")
        }
        items(uiStateFlow.value.productList) {
            if (it != null) {
                ProductItem(productItem = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    ProductScreen(
        uiStateFlow = MutableStateFlow(
            ProductScreenUiState()
        )
    )
}