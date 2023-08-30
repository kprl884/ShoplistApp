package com.example.shoplistapp.domain.di

import com.example.shoplistapp.data.local.db.ShoppingDatabase
import com.example.shoplistapp.data.local.repository.ShoppingDataSource
import com.example.shoplistapp.data.network.service.datasource.ProductListDataSource
import com.example.shoplistapp.data.network.service.repository.ProductService
import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import com.example.shoplistapp.domain.repository.remote.ProductRemoteRepository
import com.example.shoplistapp.domain.usecase.local.BasketListDeleteUseCaseLocal
import com.example.shoplistapp.domain.usecase.local.BasketListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.BasketListInsertUseCaseLocal
import com.example.shoplistapp.domain.usecase.remote.ProductListGetUseCaseRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetShoppingListLocalUseCase(
        shoppingLocalRepository: ShoppingLocalRepository
    ): BasketListGetLocalUseCase {
        return BasketListGetLocalUseCase(
            shoppingLocalRepository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideShoppingLocalRepository(
        db: ShoppingDatabase
    ): ShoppingLocalRepository {
        return ShoppingDataSource(db = db)
    }

    @ViewModelScoped
    @Provides
    fun provideProductRemoteRepository(productService: ProductService): ProductRemoteRepository {
        return ProductListDataSource(productService)
    }

    @ViewModelScoped
    @Provides
    fun provideGetShoppingListRemoteUseCase(
        productRemoteRepository: ProductRemoteRepository
    ): ProductListGetUseCaseRemote {
        return ProductListGetUseCaseRemote(
            productRemoteRepository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideDeleteShoppingItemLocalUseCase(
        shoppingLocalRepository: ShoppingLocalRepository
    ): BasketListDeleteUseCaseLocal {
        return BasketListDeleteUseCaseLocal(
            shoppingLocalRepository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideInsertShoppingItemLocalUseCase(
        shoppingLocalRepository: ShoppingLocalRepository
    ): BasketListInsertUseCaseLocal {
        return BasketListInsertUseCaseLocal(
            shoppingLocalRepository
        )
    }
}
