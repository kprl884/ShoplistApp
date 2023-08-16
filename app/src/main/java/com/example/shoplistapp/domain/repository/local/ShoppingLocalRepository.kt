package com.example.shoplistapp.domain.repository.local

import com.example.shoplistapp.domain.entity.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingLocalRepository {
    suspend fun upsert(item: ShoppingItem)

    suspend fun delete(item: ShoppingItem)

    suspend fun getAllShoppingItems() : Flow<List<ShoppingItem>>
}