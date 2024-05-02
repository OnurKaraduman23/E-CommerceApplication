package com.example.e_commerceapplication.data.remote.dto


import com.example.e_commerceapplication.domain.model.Product
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ProductDto(
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
    val productRatingDto: RatingDto,
    @SerializedName("title")
    @Expose
    val title: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        productRatingDto = productRatingDto,
        title = title
    )

}