package com.example.shoplistapp.presentation.shoppingitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.ui.theme.ShoplistAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ShoppingItemScreen(
    uiStateFlow: StateFlow<ShoppingScreenUiState>,
    onEvent: (ShoppingUiEvent) -> Unit
) {
    var item by remember {
        mutableIntStateOf(0)
    }

    Column {
        Text(text = "Add", modifier = Modifier
            .clickable {
                item += 1
                onEvent(
                    ShoppingUiEvent.OnInsertItem(
                        ShoppingItem("bir", 12)
                    )
                )
            }
        )
        Text(text = "Delete")
        Text(text = "Get List")

        LazyColumn {
            items(uiStateFlow.value.shoppingList) {
                if (it != null) {
                    Text(text = it.name)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShoppingItemScreen() {
    ShoplistAppTheme {
        ShoppingItemScreen(
            uiStateFlow = MutableStateFlow(
                ShoppingScreenUiState()
            ),
            onEvent = {}
        )
    }
}