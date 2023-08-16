package com.example.shoplistapp.domain.usecase.remote

import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.remote.ShoppingRemoteRepository
import kotlinx.coroutines.flow.catch

class ShoppingListGetUseCaseRemote(private val shoppingRemoteRepository: ShoppingRemoteRepository) {
    suspend operator fun invoke(onResult: suspend (List<ProductItem>) -> Unit) {
        return shoppingRemoteRepository.getProducts()
            .catch {
                println(it.localizedMessage)
            }
            .collect {
                onResult(
                    it
                )
            }
    }
}