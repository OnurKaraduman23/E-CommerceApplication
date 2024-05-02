package com.example.e_commerceapplication.presentation.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.domain.usecase.get_products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private val _state = MutableStateFlow<ProductsListState>(ProductsListState())
    val state: StateFlow<ProductsListState> = _state

    init {
        getProducts()
    }

    private fun getProducts(){
        getProductsUseCase().onEach {result->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductsListState(products = result?.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ProductsListState(isError = result.message ?: "An unexpected error Occured")
                }
                is Resource.Loading -> {
                    _state.value = ProductsListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}