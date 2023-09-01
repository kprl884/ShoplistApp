package com.example.shoplistapp.domain.usecase.local

import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository

class BasketListDeleteUseCaseLocal(private val shoppingLocalRepository: ShoppingLocalRepository) {
    suspend operator fun invoke(
        item: ProductItem
    ) {
        println("data domain BasketListDeleteUseCaseLocal ${item.title}} ")
        return shoppingLocalRepository.delete(item)
    }
}