package com.cakii.sennaquestion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cakii.sennaquestion3.presentation.adapter.MenuAdapter
import com.cakii.sennaquestion3.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_restaurants.progress_bar
import kotlinx.android.synthetic.main.fragment_restaurants.recycler_view

class MenusFragment : Fragment() {

    companion object {
        private const val ARGS_RESTAURANT_ID = "restaurant_id"

        fun newInstance(restaurantId: Int): MenusFragment {
            val bundle = Bundle().apply {
                putInt(ARGS_RESTAURANT_ID, restaurantId)
            }
            return MenusFragment().apply {
                arguments = bundle
            }
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(RestaurantViewModel::class.java).also {
            App.component.inject(it)
        }
    }

    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_menu, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuAdapter = MenuAdapter()
        recycler_view.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.restaurant.observe(this, Observer {
            progress_bar.visibility = View.GONE
            Glide.with(this@MenusFragment).load(it.imageUrl).into(imv_restaurant_image)
            tv_restaurant_name.text = it.name
            tv_restaurant_description.text = it.kind
            menuAdapter.menus = it.menus
        })
    }

    override fun onResume() {
        super.onResume()
        arguments?.getInt(ARGS_RESTAURANT_ID)?.let {
            progress_bar.visibility = View.VISIBLE
            viewModel.getRestaurant(it)
        }
    }
}