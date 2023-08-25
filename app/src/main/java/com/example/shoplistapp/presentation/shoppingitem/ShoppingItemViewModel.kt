package com.example.shoplistapp.presentation.shoppingitem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.entity.ShoppingItem
import com.example.shoplistapp.domain.usecase.local.ShoppingListDeleteUseCaseLocal
import com.example.shoplistapp.domain.usecase.local.ShoppingListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.ShoppingListInsertUseCaseLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class ShoppingItemViewModel(
    private val shoppingListInsertUseCaseLocal: ShoppingListInsertUseCaseLocal,
    private val shoppingListGetLocalUseCase: ShoppingListGetLocalUseCase,
    private val deleteUseCaseLocal: ShoppingListDeleteUseCaseLocal
) : ViewModel() {
    private val _uiState = MutableStateFlow(ShoppingScreenUiState())
    val uiState: StateFlow<ShoppingScreenUiState> = _uiState.asStateFlow()

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingListInsertUseCaseLocal.invoke(item) {
            _uiState.update { currentState->
                currentState.copy(
                )
            }
        }
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        deleteUseCaseLocal.invoke(item)
    }

    fun getList(){
        _uiState.update { currentState->
            currentState.copy(
                isShoppingListLoading = true
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            shoppingListGetLocalUseCase.invoke {dataList ->
                _uiState.update { currentState->
                    currentState.copy(
                        isShoppingListLoading = false,
                        shoppingList = dataList
                    )
                }
            }
        }
    }
}

data class ShoppingScreenUiState(
    val isShoppingListLoading: Boolean = false,
    val shoppingList: List<ShoppingItem?> = listOf()
)