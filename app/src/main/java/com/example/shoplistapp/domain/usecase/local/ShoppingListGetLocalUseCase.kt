package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import kotlinx.coroutines.flow.catch

class ShoppingListGetLocalUseCase(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        onResult: suspend (List<ShoppingItem>) -> Unit
    ){
        return shoppingLocalRepository.getAllShoppingItems()
            .catch {
               println(it.localizedMessage)
            }
            .collect{
                onResult(it)
            }
    }
}