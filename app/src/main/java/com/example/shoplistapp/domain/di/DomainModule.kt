package com.example.shoplistapp.domain.di

import com.example.shoplistapp.domain.repository.local.ShoppingLocalRepository
import com.example.shoplistapp.domain.repository.remote.ProductRemoteRepository
import com.example.shoplistapp.domain.usecase.local.ShoppingListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.remote.ProductListGetUseCaseRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetShoppingListLocalUseCase(
        shoppingLocalRepository: ShoppingLocalRepository
    ): ShoppingListGetLocalUseCase {
        return ShoppingListGetLocalUseCase(
            shoppingLocalRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetShoppingListRemoteUseCase(
        productRemoteRepository: ProductRemoteRepository
    ): ProductListGetUseCaseRemote {
        return ProductListGetUseCaseRemote(
            productRemoteRepository
        )
    }
}
