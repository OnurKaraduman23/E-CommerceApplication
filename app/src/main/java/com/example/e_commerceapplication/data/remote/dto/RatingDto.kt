package com.example.e_commerceapplication.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class RatingDto(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("rate")
    @Expose
    val rate: Double
)