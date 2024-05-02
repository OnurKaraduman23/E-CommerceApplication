package com.example.e_commerceapplication.data.repository

import com.example.e_commerceapplication.data.EcommerceApi
import com.example.e_commerceapplication.data.remote.dto.ProductsDto
import com.example.e_commerceapplication.domain.repository.ProductRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api:EcommerceApi
):ProductRepository {

    override suspend fun getProducts(): List<ProductsDto> {
        return api.getProducts()
    }
}