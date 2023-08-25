package com.example.shoplistapp.presentation.shoppingitem

import com.example.shoplistapp.domain.entity.ShoppingItem

sealed class ShoppingUiEvent {
    data class OnDeleteItem(val item: ShoppingItem) : ShoppingUiEvent()

    data class OnInsertItem(val item: ShoppingItem) : ShoppingUiEvent()
}