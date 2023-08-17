package com.example.shoplistapp.data.di

import com.example.shoplistapp.data.local.db.ShoppingDatabase
import com.example.shoplistapp.data.local.repository.ShoppingDataSource
import com.example.shoplistapp.data.network.service.datasource.ShopListDataSource
import com.example.shoplistapp.data.network.service.repository.ProductService
import com.example.shoplistapp.data.utils.Constant.BASE_URL
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import com.example.shoplistapp.domain.repository.remote.ShoppingRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object NetworkModule {
    @Provides
    fun provideAnalyticsService(
    ): ProductService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
            .create(ProductService::class.java)
    }

    @Provides
    @Singleton
    fun provideShopListDataSource(
        service: ProductService
    ): ShoppingRemoteRepository {
        return ShopListDataSource(
            service
        )
    }

    @Provides
    @Singleton
    fun provideShopListLocalDataSource(
        db: ShoppingDatabase
    ): ShoppingLocalRepository {
        return ShoppingDataSource(
            db
        )
    }
}