package com.example.shoplistapp.presentation.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplistapp.domain.usecase.local.BasketListDeleteUseCaseLocal
import com.example.shoplistapp.domain.usecase.local.BasketListGetLocalUseCase
import com.example.shoplistapp.domain.usecase.local.BasketListInsertUseCaseLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketScreenViewModel @Inject constructor(
    private val basketListGetLocalUseCase: BasketListGetLocalUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(BasketScreenUiState())
    val uiState: StateFlow<BasketScreenUiState> = _uiState.asStateFlow()

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            basketListGetLocalUseCase.invoke { dataList ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isListLoading = false,
                        basketList = dataList
                    )
                }
            }
        }
    }
}