package com.example.shoplistapp.presentation.product

import com.example.shoplistapp.domain.entity.ProductItem

data class ProductScreenUiState(
    val isProductListLoading: Boolean = false,
    val productList: List<ProductItem>? = null
)