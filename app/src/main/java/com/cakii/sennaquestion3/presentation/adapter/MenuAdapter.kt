package com.cakii.sennaquestion3.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cakii.sennaquestion3.R
import com.cakii.sennaquestion3.data.entity.Menu
import kotlinx.android.synthetic.main.item_menu.view.*
import kotlin.properties.Delegates

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    var menus by Delegates.observable(listOf(Menu())) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_menu,
                parent,
                false
            )
        )

    override fun getItemCount() = menus.count()

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.view.apply {
            menus[position].let {
                tv_title.text = it.name
                tv_description.text = "Price: ${it.price} ฿"
                Glide.with(this).load("${it.imageUrl}l").into(imv_image)
            }
        }
    }

    class MenuViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}