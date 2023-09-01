package com.example.shoplistapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.usecase.local.BasketListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.BasketListInsertUseCaseLocal
import com.example.shoplistapp.domain.usecase.remote.ProductListGetUseCaseRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val productListGetUseCaseRemote: ProductListGetUseCaseRemote,
    private val basketListInsertUseCaseLocal: BasketListInsertUseCaseLocal,
    private val basketListGetLocalUseCase: BasketListGetLocalUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        getProduct()
    }

    fun onEvent(uiEvent: HomeScreenUiEvent) {
        when (uiEvent) {
            is HomeScreenUiEvent.OnSaveItem -> {
                saveProductItem(uiEvent.item)
            }

            else -> {}
        }
    }

    private fun addProductItem(item: ProductItem) {
        val basketList: ArrayList<ProductItem> = arrayListOf()
        _uiState.value.basketList?.let { basketList.addAll(it) }
        basketList.add(item)
        _uiState.update { currentState ->
            currentState.copy(
                basketList = basketList
            )
        }
    }

    private fun subtractProductItem(item: ProductItem) {
        val basketList: ArrayList<ProductItem> = arrayListOf()
        _uiState.value.basketList?.let { basketList.addAll(it) }
        basketList.remove(item)
        _uiState.update { currentState ->
            currentState.copy(
                basketList = basketList
            )
        }
    }

    private fun saveProductItem(item: ProductItem) {
        viewModelScope.launch {
            basketListInsertUseCaseLocal.invoke(item) {}
        }
        getUpdateBasketList()
    }

    private fun getProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            productListGetUseCaseRemote.invoke { dataList ->
                _uiState.update { currentState ->
                    currentState.copy(
                        productList = dataList
                    )
                }
            }
        }
    }

    private fun getUpdateBasketList() {
        viewModelScope.launch(Dispatchers.IO) {
            basketListGetLocalUseCase.invoke { dataList ->
                _uiState.update { currentState ->
                    currentState.copy(
                        basketList = dataList
                    )
                }
            }
        }
    }
}
