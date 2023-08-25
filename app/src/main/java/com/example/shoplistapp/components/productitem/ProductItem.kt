package com.example.shoplistapp.components.productitem

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoplistapp.domain.entity.ProductItem

@Composable
fun ProductItem(productItem: ProductItem) {
    Row {
        Text(text = productItem.title)
        Text(text = productItem.category)
        Text(text = productItem.description)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewProductItem() {
   ProductItem(
        ProductItem(3, "Şapka", 500f, "Şapka", "Şapka",
        "")
    )
}