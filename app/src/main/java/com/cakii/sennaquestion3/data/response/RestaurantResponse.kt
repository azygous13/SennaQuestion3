package com.cakii.sennaquestion3.data.response


import com.cakii.sennaquestion3.data.entity.Menu
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("menus")
    val menus: List<Menu>,
    @SerializedName("name")
    val name: String
)