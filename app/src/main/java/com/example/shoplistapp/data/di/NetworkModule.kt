package com.example.shoplistapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.shoplistapp.data.local.db.ShoppingDao
import com.example.shoplistapp.data.local.db.ShoppingDatabase
import com.example.shoplistapp.data.network.service.repository.ProductService
import com.example.shoplistapp.data.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideAnalyticsService(
        retrofit: Retrofit
    ): ProductService {
        return retrofit.create(ProductService::class.java)
    }
/*

    @Provides
    @Singleton
    fun provideShoppingDatabase(@ApplicationContext context: Context): ShoppingDatabase {
        return ShoppingDatabase(context)
    }

 */

    @Provides
    @Singleton
    fun provideShoppingDatabase(@ApplicationContext context: Context): ShoppingDatabase {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            "ShoppingDB.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideShoppingDao(database: ShoppingDatabase): ShoppingDao {
        return database.getShoppingDao()
    }
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}