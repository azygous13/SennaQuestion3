package com.cakii.sennaquestion3.data.entity

import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("deliver_time")
    val deliverTime: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_url")
    val imageUrl: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: String = "",
    @SerializedName("restaurant_id")
    val restaurantId: Int = 0
)