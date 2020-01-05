package com.cakii.sennaquestion3.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cakii.sennaquestion3.R
import com.cakii.sennaquestion3.data.entity.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.view.*
import kotlin.properties.Delegates

interface OnRestaurantListener {
    fun onRestaurantClicked(restaurantId: Int)
}

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    var restaurants by Delegates.observable(listOf(Restaurant())) { _, _, _ -> notifyDataSetChanged() }
    var listener: OnRestaurantListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_restaurant,
                parent,
                false
            )
        )

    override fun getItemCount() = restaurants.count()

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.view.apply {
            restaurants[position].let { restaurant ->
                tv_title.text = restaurant.name
                tv_description.text = restaurant.kind
                Glide.with(this).load("${restaurant.imageUrl}").into(imv_image)
                setOnClickListener {
                    listener?.onRestaurantClicked(restaurant.id)
                }
            }
        }
    }

    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}