package com.example.shoplistapp.components.productitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.shoplistapp.R
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.presentation.home.HomeScreenUiState

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShoppingItemCard(
    shoppingItem: ProductItem,
    uiState: HomeScreenUiState,
    onSaveClick: (shoppingItem: ProductItem) -> Unit
) {
    var count by remember { mutableIntStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            GlideImage(
                model = shoppingItem.image,
                contentDescription = "Item image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = shoppingItem.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Description: $${shoppingItem.description}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Price: $${shoppingItem.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        count += 1
                        shoppingItem.count++
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
                ) {
                    Text(text = "Add")
                }
                Button(
                    onClick = {
                        if (count >= 1) count -= 1
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
                ) {
                    Text(text = "Subtract")
                }
                Button(
                    onClick = {
                        onSaveClick(shoppingItem)
                        count = 0
                    },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(40.dp)
                ) {
                    Text(text = stringResource(R.string.save) + " $count")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewShoppingCard() {
    ShoppingItemCard(
        shoppingItem = ProductItem(
            id = 1,
            title = "Title",
            price = 200f,
            category = "Category",
            description = "Description for Item ",
            image = "",
            1
        ),
        HomeScreenUiState(
            isProductListLoading = false,
            listOf(),
            listOf()
        ),
        onSaveClick = { }
    )
}