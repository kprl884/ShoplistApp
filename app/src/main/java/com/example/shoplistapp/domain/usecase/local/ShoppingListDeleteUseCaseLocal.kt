package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository

class ShoppingListDeleteUseCaseLocal(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        item: ShoppingItem
    ) {
        return shoppingLocalRepository.delete(item)
    }
}