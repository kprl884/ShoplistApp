package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository

class BasketListInsertUseCaseLocal(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        item: ProductItem,
        onResult : suspend  () -> Unit
    ){
        return shoppingLocalRepository.upsert(item = item)
    }
}