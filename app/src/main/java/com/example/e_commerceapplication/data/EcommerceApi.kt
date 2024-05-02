package com.example.e_commerceapplication.data

import com.example.e_commerceapplication.data.remote.dto.ProductsDto
import retrofit2.http.GET

interface EcommerceApi {
    @GET("products")
    suspend fun getProducts(): List<ProductsDto>
}