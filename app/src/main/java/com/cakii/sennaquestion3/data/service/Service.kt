package com.cakii.sennaquestion3.data.service

import com.cakii.sennaquestion3.data.response.RestaurantResponse
import com.cakii.sennaquestion3.data.response.RestaurantsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("/restaurants.json")
    fun getRestaurants(): Single<RestaurantsResponse>

    @GET("/restaurants/{id}.json")
    fun getRestaurant(@Path("id") id: Int): Single<RestaurantResponse>
}