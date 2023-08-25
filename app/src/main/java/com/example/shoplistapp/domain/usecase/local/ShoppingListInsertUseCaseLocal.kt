package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository

class ShoppingListInsertUseCaseLocal(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        item: ShoppingItem,
        onResult : suspend  () -> Unit
    ){
        return shoppingLocalRepository.upsert(item = item)
    }
}