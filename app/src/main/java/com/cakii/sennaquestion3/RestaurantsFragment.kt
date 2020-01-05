package com.cakii.sennaquestion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cakii.sennaquestion3.presentation.adapter.OnRestaurantListener
import com.cakii.sennaquestion3.presentation.adapter.RestaurantAdapter
import com.cakii.sennaquestion3.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_restaurants.*

class RestaurantsFragment : Fragment(), OnRestaurantListener {

    companion object {
        fun newInstance(): RestaurantsFragment {
            return RestaurantsFragment()
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(RestaurantViewModel::class.java).also {
            App.component.inject(it)
        }
    }

    lateinit var restaurantAdapter: RestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_restaurants, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantAdapter = RestaurantAdapter().apply {
            listener = this@RestaurantsFragment
        }
        recycler_view.apply {
            adapter = restaurantAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.restaurants.observe(this, Observer {
            progress_bar.visibility = View.GONE
            restaurantAdapter.restaurants = it.restaurants
        })
    }

    override fun onResume() {
        super.onResume()
        progress_bar.visibility = View.VISIBLE
        viewModel.getRestaurants()
    }

    override fun onRestaurantClicked(restaurantId: Int) {
        fragmentManager?.commit {
            addToBackStack("")
            setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            add(R.id.fragment_container, MenusFragment.newInstance(restaurantId))
        }
    }
}