package com.example.shoplistapp.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shopping_items")
data class ShoppingItem(
    @ColumnInfo("item_name")
    val name: String,
    @ColumnInfo("item_amount")
    val amount: Int) {
    @PrimaryKey(autoGenerate = true)
    var id : String? = null
}