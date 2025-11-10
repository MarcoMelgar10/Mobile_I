package com.example.practico_3.data.model

import com.google.gson.annotations.SerializedName

data class Place(
    val id: Int? = null,
    val name: String,
    val city: String,
    @SerializedName("trip_id")
    val tripId: Int,
    val description: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    val directions: String? = null,
    @SerializedName("time_to_spend")
    val timeToSpend: String? = null,
    val price: String? = null
)
