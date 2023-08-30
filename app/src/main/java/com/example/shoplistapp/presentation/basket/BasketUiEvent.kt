package com.example.shoplistapp.presentation.basket

import com.example.shoplistapp.domain.entity.ProductItem

sealed class BasketUiEvent {
    data class OnDeleteItem(val item: ProductItem) : BasketUiEvent()

    data class OnInsertItem(val item: ProductItem) : BasketUiEvent()
}