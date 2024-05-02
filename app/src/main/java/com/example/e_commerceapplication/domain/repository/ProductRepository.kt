package com.example.e_commerceapplication.domain.repository

import com.example.e_commerceapplication.data.remote.dto.ProductsDto

interface ProductRepository {

    suspend fun getProducts(): List<ProductsDto>
}