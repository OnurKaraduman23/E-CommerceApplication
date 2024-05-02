package com.example.e_commerceapplication.presentation.fragments.product_detail

import com.example.e_commerceapplication.domain.model.Product

data class ProductDetailState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val isError: String = ""
)