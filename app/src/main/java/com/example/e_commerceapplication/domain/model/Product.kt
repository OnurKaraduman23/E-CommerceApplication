package com.example.e_commerceapplication.domain.model

import com.example.e_commerceapplication.data.remote.dto.RatingDto


data class Product(
    val category: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val price: Double?,
    val productRatingDto: RatingDto?,
    val title: String?

)