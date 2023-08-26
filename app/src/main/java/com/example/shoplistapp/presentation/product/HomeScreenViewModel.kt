package com.example.shoplistapp.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val productListGetUseCaseRemote: ProductListGetUseCaseRemote
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        getProduct()
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
