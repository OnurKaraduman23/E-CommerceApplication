package com.example.e_commerceapplication.data

import com.example.e_commerceapplication.data.remote.dto.ProductDto
import com.example.e_commerceapplication.data.remote.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EcommerceApi {
    @GET("products")
    suspend fun getProducts(): List<ProductsDto>

    @GET("products/{productId}")
    suspend fun getProduct(@Path("productId") productId:Int): ProductDto
}