package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import kotlinx.coroutines.flow.catch

class BasketListGetLocalUseCase(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        onResult: suspend (List<ProductItem>) -> Unit
    ){
        return shoppingLocalRepository.getAllShoppingItems()
            .catch {
               println(it.localizedMessage)
            }
            .collect{
                println("data domain BasketListGetLocalUseCase ${it.size} ")
                onResult(it)
            }
    }
}