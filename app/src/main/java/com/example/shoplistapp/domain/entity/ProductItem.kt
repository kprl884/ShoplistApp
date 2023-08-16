package com.example.shoplistapp.domain.entity

data class ProductItem(
    val id: Int,
    val title: String,
    val price: Float,
    val category: String,
    val description: String,
    val image: String
)