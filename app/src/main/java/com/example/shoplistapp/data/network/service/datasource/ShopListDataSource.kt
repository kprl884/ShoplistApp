package com.example.shoplistapp.data.network.service.datasource

import com.example.shoplistapp.data.network.service.repository.ProductService
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.remote.ShoppingRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ShopListDataSource(private val productService: ProductService) : ShoppingRemoteRepository {
    override suspend fun getProducts(): Flow<List<ProductItem>> {
        return flow {
            try {
                emit(productService.getProducts())
            } catch (e: Exception) {

            }
        }.flowOn(Dispatchers.IO)
    }
}