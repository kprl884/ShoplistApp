package com.example.shoplistapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoplistapp.domain.entity.ProductItem

@Database(
    entities = [ProductItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao
}