package com.example.shoplistapp.presentation.shoppingitem

import com.example.shoplistapp.domain.entity.ShoppingItem

data class ShoppingScreenUiState(
    val isShoppingListLoading: Boolean = false,
    val shoppingList: List<ShoppingItem?> = listOf()
)