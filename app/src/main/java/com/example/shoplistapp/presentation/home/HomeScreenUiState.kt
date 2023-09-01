package com.example.shoplistapp.presentation.home

import com.example.shoplistapp.domain.entity.ProductItem

data class HomeScreenUiState(
    val isProductListLoading: Boolean = false,
    val productList: List<ProductItem>? = null,
    val basketList: List<ProductItem>? = null
)