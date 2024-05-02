package com.example.e_commerceapplication.domain.repository

import com.example.e_commerceapplication.data.remote.dto.ProductDto
import com.example.e_commerceapplication.data.remote.dto.ProductsDto

interface ProductRepository {

    suspend fun getProducts(): List<ProductsDto>

    suspend fun getProduct(productId:Int): ProductDto
}