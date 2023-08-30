package com.example.shoplistapp.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.usecase.local.BasketListInsertUseCaseLocal
import com.example.shoplistapp.domain.usecase.remote.ProductListGetUseCaseRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val productListGetUseCaseRemote: ProductListGetUseCaseRemote,
    private val basketListInsertUseCaseLocal: BasketListInsertUseCaseLocal
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<HomeScreenUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var basketlist = arrayListOf<ProductItem>()

    init {
        getProduct()
    }

    fun onEvent(uiEvent: HomeScreenUiEvent) {
        when (uiEvent) {
            is HomeScreenUiEvent.OnAddItem -> {
                addProductItem(uiEvent.item)
            }

            is HomeScreenUiEvent.OnSubtractItem -> {
                subtractProductItem(uiEvent.item)
            }

            is HomeScreenUiEvent.OnSaveItem -> {
                saveProductItem(uiEvent.item)
            }

            else -> {}
        }
    }

    private fun addProductItem(item: ProductItem) {
        basketlist = _uiState.value.basketList as ArrayList<ProductItem>
        basketlist.add(item)
        _uiState.update { currentState ->
            currentState.copy(
                basketList = basketlist
            )
        }
    }

    private fun subtractProductItem(item: ProductItem) {
        basketlist = _uiState.value.basketList as ArrayList<ProductItem>
        basketlist.remove(item)
        _uiState.update { currentState ->
            currentState.copy(
                basketList = basketlist
            )
        }
    }

    private fun saveProductItem(item: ProductItem) {
        viewModelScope.launch {
            basketListInsertUseCaseLocal.invoke(item) {

            }
        }
    }

    private fun navigate(route: String) {

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
}
