package com.example.shoplistapp.data.local.repository

import com.example.shoplistapp.data.local.db.ShoppingDatabase
import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ShoppingDataSource(private val db: ShoppingDatabase) :
    ShoppingLocalRepository {
    override suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().insert(item)
    override suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    override suspend fun getAllShoppingItems(): Flow<List<ShoppingItem>> {
        return flow {
            try {
                emit(db.getShoppingDao().getAllItems())
            } catch (e: Exception) {
                println("$e")
            }
        }.flowOn(Dispatchers.IO)
    }
}