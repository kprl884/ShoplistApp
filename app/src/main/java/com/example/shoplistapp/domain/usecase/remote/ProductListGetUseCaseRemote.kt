package com.example.shoplistapp.domain.usecase.remote

import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.remote.ProductRemoteRepository
import kotlinx.coroutines.flow.catch

class ProductListGetUseCaseRemote(private val productRemoteRepository: ProductRemoteRepository) {
    suspend operator fun invoke(onResult: suspend (List<ProductItem>) -> Unit) {
        return productRemoteRepository.getProducts()
            .catch {
                println(it.localizedMessage)
            }
            .collect {
                println("data - domain ${it.size}")
                onResult(
                    it
                )
            }
    }
}