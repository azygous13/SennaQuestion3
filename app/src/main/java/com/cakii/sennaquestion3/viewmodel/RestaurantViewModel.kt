package com.cakii.sennaquestion3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cakii.sennaquestion3.data.response.RestaurantResponse
import com.cakii.sennaquestion3.data.response.RestaurantsResponse
import com.cakii.sennaquestion3.repository.RestaurantRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantViewModel : ViewModel() {

    @Inject
    lateinit var repository: RestaurantRepository

    var restaurants = MutableLiveData<RestaurantsResponse>()
    var restaurant = MutableLiveData<RestaurantResponse>()

    fun getRestaurants() = repository.getRestaurants()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe({ response -> restaurants.value = response },
            { e -> restaurants.value = null })

    fun getRestaurant(id: Int) = repository.getRestaurant(id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe({ response -> restaurant.value = response },
            { e -> restaurant.value = null })
}