package com.example.shoplistapp.presentation.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.components.productitem.ProductItem
import com.example.shoplistapp.ui.theme.ShoplistAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun BasketScreen(
    uiStateFlow: StateFlow<BasketScreenUiState>,
    onEvent: (BasketUiEvent) -> Unit
) {
    Column {
        LazyColumn {
            items(uiStateFlow.value.basketList) {
                if (it != null) {
                    ProductItem(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShoppingItemScreen() {
    ShoplistAppTheme {
        BasketScreen(
            uiStateFlow = MutableStateFlow(
                BasketScreenUiState()
            ),
            onEvent = {}
        )
    }
}