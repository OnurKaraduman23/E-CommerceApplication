package com.example.e_commerceapplication.presentation.fragments.products

import com.example.e_commerceapplication.domain.model.Products


data class ProductsListState(
    val isLoading: Boolean = false,
    val products: List<Products> = emptyList(),
    val isError: String = ""
) {
}