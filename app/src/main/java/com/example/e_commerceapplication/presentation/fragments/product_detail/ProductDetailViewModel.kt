package com.example.e_commerceapplication.presentation.fragments.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapplication.common.Resource
import com.example.e_commerceapplication.domain.usecase.get_product.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val _state =MutableStateFlow<ProductDetailState>(ProductDetailState())
    val state: MutableStateFlow<ProductDetailState> = _state


    fun getProduct(productId: Int) {
        getProductUseCase(productId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ProductDetailState(product = result.data )
                }

                is Resource.Error -> {
                    _state.value =
                        ProductDetailState(isError = result.message ?: "An unexpected error uccured")

                }

                is Resource.Loading -> {
                    _state.value = ProductDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}