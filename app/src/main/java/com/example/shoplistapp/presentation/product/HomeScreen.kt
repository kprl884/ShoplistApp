package com.example.shoplistapp.presentation.product

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoplistapp.R
import com.example.shoplistapp.components.productitem.ShoppingItemCard
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.ui.theme.ShoplistAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    uiStateFlow: StateFlow<HomeScreenUiState>,
    onEvent: (HomeScreenUiEvent) -> Unit,
) {
    val uiState by uiStateFlow.collectAsState()
    ShoplistAppTheme() {
        LazyColumn(modifier = Modifier) {
            item {
                Row(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.primary)
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            onEvent.invoke(HomeScreenUiEvent.OnNavigate("basket"))
                        }) {
                        Icon(
                            painter = painterResource(R.drawable.purchase),
                            contentDescription = stringResource(id = R.string.basket),
                            modifier = Modifier.size(60.dp, 60.dp),
                            tint = Color.Black
                        )
                        Text(
                            text = "${uiState.basketList?.size ?: 0}",
                            modifier = Modifier
                                .align(Alignment.BottomEnd),
                            fontSize = 32.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            uiState.productList?.let {
                items(it) { productItem ->
                    ShoppingItemCard(
                        productItem,
                        { onEvent.invoke(HomeScreenUiEvent.OnAddItem(productItem)) },
                        { onEvent.invoke(HomeScreenUiEvent.OnSubtractItem(productItem)) },
                        { onEvent.invoke(HomeScreenUiEvent.OnSaveItem(productItem)) })
                }
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
        ),
        onEvent = { }
    )
}