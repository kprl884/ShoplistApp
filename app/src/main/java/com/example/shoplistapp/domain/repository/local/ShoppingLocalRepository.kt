package com.example.shoplistapp.domain.repository.local

import com.example.shoplistapp.domain.entity.ProductItem
import kotlinx.coroutines.flow.Flow

interface ShoppingLocalRepository {
    suspend fun upsert(item: ProductItem)
    suspend fun delete(item: ProductItem)
    suspend fun getAllShoppingItems() : Flow<List<ProductItem>>
}