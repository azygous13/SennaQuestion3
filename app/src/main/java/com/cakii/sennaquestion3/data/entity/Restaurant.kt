package com.cakii.sennaquestion3.data.entity

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_url")
    val imageUrl: String = "",
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("name")
    val name: String = ""
)