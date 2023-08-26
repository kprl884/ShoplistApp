package com.example.shoplistapp.presentation.product

import com.example.shoplistapp.domain.entity.ProductItem

data class HomeScreenUiState(
    val isProductListLoading: Boolean = false,
    val productList: List<ProductItem>? = null
)