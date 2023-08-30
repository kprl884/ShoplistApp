package com.example.shoplistapp.presentation.basket

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
import com.example.shoplistapp.ui.theme.ShoplistAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun BasketScreen(
    uiStateFlow: StateFlow<BasketScreenUiState>,
    onEvent: (BasketUiEvent) -> Unit
) {
    var item by remember {
        mutableIntStateOf(0)
    }
    val localList = MutableStateFlow(BasketScreenUiState())
    //val localList: StateFlow<ShoppingScreenUiState> = _localList.asStateFlow()

    Column {
        Text(text = "Add", modifier = Modifier
            .clickable {
                item += 1

            }
        )
        Text(text = "Delete", modifier = Modifier
            .clickable {
                item -= 1

            })
        Text(text = "Get List", modifier = Modifier
            .clickable {
                localList.value.basketList = uiStateFlow.value.basketList
            })

        LazyColumn {
            items(localList.value.basketList) {
                if (it != null) {
                    Text(text = it.title)
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