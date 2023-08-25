package com.example.shoplistapp.presentation.product
/*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.usecase.remote.ProductListGetUseCaseRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ProductScreenViewModel(
    private val productListGetUseCaseRemote: ProductListGetUseCaseRemote
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductScreenUiState())
    val uiState: StateFlow<ProductScreenUiState> = _uiState.asStateFlow()

    fun getProduct() {
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
*/
/*
data class ProductScreenUiState(
    val isProductListLoading: Boolean = false,
    val productList: List<ProductItem?> = listOf()
)

 */