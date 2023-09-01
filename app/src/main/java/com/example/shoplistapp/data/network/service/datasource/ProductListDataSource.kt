package com.example.shoplistapp.data.network.service.datasource

import com.example.shoplistapp.data.network.service.repository.ProductService
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.remote.ProductRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductListDataSource(private val productService: ProductService) : ProductRemoteRepository {
    override suspend fun getProducts(): Flow<List<ProductItem>> {
        return flow {
            try {
                println("dp shop  getProducts = ${productService.getProducts()}")

                val response = productService.getProducts()
                emit(response)
            }catch (e: Exception){
                println(e.message)
            }
        }.flowOn(Dispatchers.IO)
    }
}