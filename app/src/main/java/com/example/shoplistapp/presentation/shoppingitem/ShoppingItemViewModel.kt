package com.example.shoplistapp.presentation.shoppingitem

import androidx.lifecycle.ViewModel
import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.usecase.local.ShoppingListDeleteUseCaseLocal
import com.example.shoplistapp.domain.usecase.local.ShoppingListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.ShoppingListInsertUseCaseLocal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingItemViewModel(
    private val shoppingListInsertUseCaseLocal: ShoppingListInsertUseCaseLocal,
    private val shoppingListGetLocalUseCase: ShoppingListGetLocalUseCase,
    private val deleteUseCaseLocal: ShoppingListDeleteUseCaseLocal
) : ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingListInsertUseCaseLocal.invoke(item) {}
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        deleteUseCaseLocal.invoke(item) {}
    }

    fun getItems() = CoroutineScope(Dispatchers.Main).launch {
        shoppingListGetLocalUseCase.invoke {

        }
    }
}