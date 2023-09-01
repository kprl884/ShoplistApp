package com.example.shoplistapp.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shopping_items")
data class ProductItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("item_title")
    val title: String,
    @ColumnInfo("item_price")
    val price: Float,
    @ColumnInfo("item_category")
    val category: String,
    @ColumnInfo("item_description")
    val description: String,
    @ColumnInfo("item_image")
    val image: String,
    @ColumnInfo("item_count")
    var count: Int
)