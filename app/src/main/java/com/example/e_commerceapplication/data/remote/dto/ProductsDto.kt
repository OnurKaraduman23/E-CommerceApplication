package com.example.e_commerceapplication.data.remote.dto


import com.example.e_commerceapplication.domain.model.Products
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ProductsDto(
    @SerializedName("category")
    @Expose
    val category: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("price")
    @Expose
    val price: Double,
    @SerializedName("rating")
    @Expose
    val ratingDto: RatingDto,
    @SerializedName("title")
    @Expose
    val title: String
)

fun ProductsDto.toProducts(): Products {
    return Products(
        id = id,
        title = title,
        description = description,
        price = price,
        image = image,
        ratingDto = ratingDto
    )

}