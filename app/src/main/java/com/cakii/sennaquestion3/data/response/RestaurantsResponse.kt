package com.cakii.sennaquestion3.data.response


import com.cakii.sennaquestion3.data.entity.Restaurant
import com.google.gson.annotations.SerializedName

data class RestaurantsResponse(
    @SerializedName("restaurants")
    val restaurants: List<Restaurant>
)