package com.example.shoplistapp.presentation.basket

import com.example.shoplistapp.domain.entity.ProductItem

data class BasketScreenUiState(
    val isListLoading: Boolean = false,
    var basketList: List<ProductItem?> = listOf()
)