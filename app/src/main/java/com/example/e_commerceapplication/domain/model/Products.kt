package com.example.e_commerceapplication.domain.model

import com.example.e_commerceapplication.data.remote.dto.RatingDto

data class Products(
    var id: Int?,
    var title: String?,
    var description: String?,
    var price: Double?,
    var image: String?,
    var ratingDto: RatingDto?
) {
}