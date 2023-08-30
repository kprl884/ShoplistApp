package com.example.shoplistapp.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoplistapp.domain.entity.ProductItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ProductItem)

    @Delete
    suspend fun delete(item: ProductItem)

    @Query("SELECT * FROM shopping_items")
    suspend fun getAllItems() : List<ProductItem>
}