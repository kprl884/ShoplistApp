package com.example.shoplistapp.presentation.shoppingitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoplistapp.R
import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.ui.theme.ShoplistAppTheme

@Composable
fun ShoppingItemScreen(shoppingItemViewModel: ShoppingItemViewModel = viewModel()) {
    val shoppingScreenUiState by shoppingItemViewModel.uiState.collectAsState()
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    var item by remember {
        mutableIntStateOf(0)
    }

    Column {
        Text(text = "Add", modifier = Modifier
            .clickable {
                item += 1
                shoppingItemViewModel.insert(
                    ShoppingItem(
                        "item $item",
                        item
                    )
                )
            }
        )
        Text(text = "Delete")
        Text(text = "Get List")

        LazyColumn() {
            items(shoppingScreenUiState.shoppingList.size){
                Text(text = "index ${shoppingScreenUiState.shoppingList[it]}")
            }
        }
    }
}

fun addShopItem() {

}

fun deleteItem() {

}


@Preview(showBackground = true)
@Composable
fun previewShoppingItemScreen() {
    ShoplistAppTheme {
       // ShoppingItemScreen()
    }
}