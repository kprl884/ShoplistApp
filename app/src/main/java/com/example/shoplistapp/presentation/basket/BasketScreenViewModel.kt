package com.example.shoplistapp.presentation.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.entity.ProductItem
import com.example.shoplistapp.domain.usecase.local.BasketListDeleteUseCaseLocal
import com.example.shoplistapp.domain.usecase.local.BasketListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.BasketListInsertUseCaseLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
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
class BasketScreenViewModel @Inject constructor(
    private val basketListInsertUseCaseLocal: BasketListInsertUseCaseLocal,
    private val basketListGetLocalUseCase: BasketListGetLocalUseCase,
    private val deleteUseCaseLocal: BasketListDeleteUseCaseLocal
) : ViewModel() {
    private val _uiState = MutableStateFlow(BasketScreenUiState())
    val uiState: StateFlow<BasketScreenUiState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<BasketUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getList()
    }

    fun onEvent(uiEvent: BasketUiEvent){
        when(uiEvent){
            is BasketUiEvent.OnDeleteItem -> {
                delete(uiEvent.item)
            }
            is BasketUiEvent.OnInsertItem -> {
                insert(uiEvent.item)
            }
        }
    }

    private fun insert(item: ProductItem) = CoroutineScope(Dispatchers.Main).launch {
        basketListInsertUseCaseLocal.invoke(item) {
            _uiState.update { currentState->
                currentState.copy(
                )
            }
        }
    }

    private fun delete(item: ProductItem) = CoroutineScope(Dispatchers.Main).launch {
        deleteUseCaseLocal.invoke(item)
    }

    private fun getList(){
        _uiState.update { currentState->
            currentState.copy(
                isListLoading = true
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            basketListGetLocalUseCase.invoke { dataList ->
                _uiState.update { currentState->
                    currentState.copy(
                        isListLoading = false,
                        basketList = dataList
                    )
                }
            }
        }
    }
}