package com.example.shoplistapp.data.network.service.repository

import com.example.shoplistapp.domain.entity.ProductItem
import retrofit2.http.GET

interface ProductService {
    @GET("/products")
    suspend fun getProducts(): List<ProductItem>
}