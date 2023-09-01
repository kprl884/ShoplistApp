package com.example.shoplistapp.presentation.home

import com.example.shoplistapp.domain.entity.ProductItem

sealed class HomeScreenUiEvent {
    data class OnAddItem(val item: ProductItem) : HomeScreenUiEvent()
    data class OnSubtractItem(val item: ProductItem) : HomeScreenUiEvent()
    data class OnSaveItem(val item: ProductItem) : HomeScreenUiEvent()
}