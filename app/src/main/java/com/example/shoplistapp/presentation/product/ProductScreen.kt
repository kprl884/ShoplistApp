package com.example.shoplistapp.presentation.product

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.components.productitem.ProductItem
import com.example.shoplistapp.domain.entity.ProductItem

@Composable
fun ProductScreen() {
    val itemList = arrayListOf(
        ProductItem(
            0, "Nike Air",
            2500f, "Ayakkabı", "Spor ayakkabı", ""
        ),
        ProductItem(
            1, "Mont", 5000f, "Mont", "Kışlık mont",
            ""
        ),
        ProductItem(
            2, "Güneş Gözlüğü", 1500f, "Gözlük", "Güneş Gözlüğü",
            ""
        ),
        ProductItem(
            3, "Şapka", 500f, "Şapka", "Şapka",
            ""
        )

    )
    LazyColumn() {
        item {
            Text(text = "Ürünlerim")
        }
        items(itemList) {
            ProductItem(productItem = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    ProductScreen()
}