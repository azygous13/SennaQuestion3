package com.cakii.sennaquestion3.repository

import com.cakii.sennaquestion3.data.service.Service

class RestaurantRepository(private val remoteSource: Service) {

    fun getRestaurants() = remoteSource.getRestaurants()

    fun getRestaurant(id: Int)= remoteSource.getRestaurant(id)
}