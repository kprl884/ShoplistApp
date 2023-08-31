package com.example.shoplistapp.presentation.product

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoplistapp.R
import com.example.shoplistapp.components.productitem.ShoppingItemCard
import com.example.shoplistapp.domain.entity.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    uiStateFlow: StateFlow<HomeScreenUiState>,
    onEvent: (HomeScreenUiEvent) -> Unit,
    navigate: () -> Unit
) {
    val uiState by uiStateFlow.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Global Market",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navigate.invoke() },
                containerColor = MaterialTheme.colorScheme.primary,
                content = {
                    Icon(
                        Icons.Rounded.ShoppingCart,
                        contentDescription = stringResource(id = R.string.basket),
                    )
                    Text(
                        text = "${uiState.basketList?.size ?: 0}",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            )
        },
        content = {
            Surface(modifier = Modifier.padding(24.dp)) {
                LazyColumn(modifier = Modifier) {
                    uiState.productList?.let {
                        items(it) { productItem ->
                            ShoppingItemCard(
                                productItem,
                                basketListSize = uiState.basketList?.size ?: 0,
                                { onEvent(HomeScreenUiEvent.OnAddItem(productItem)) },
                                { onEvent(HomeScreenUiEvent.OnSubtractItem(productItem)) },
                                { onEvent(HomeScreenUiEvent.OnSaveItem(productItem)) }
                            )
                        }
                    }
                }
            }
        }
    )
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
        ),
        onEvent = { },
        navigate = {}
    )
}