package com.example.shoplistapp.domain.repository.remote

import com.example.shoplistapp.domain.entity.ProductItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRemoteRepository {
    suspend fun getProducts(): Flow<List<ProductItem>>
}