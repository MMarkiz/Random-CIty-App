package com.netguru.randomcityapp.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.netguru.domain.CityModel
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentListBinding
import com.netguru.randomcityapp.presentation.list.adapters.CitiesAdapter
import com.netguru.randomcityapp.presentation.main.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : BaseFragment<FragmentListBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_list

    private val citiesAdapter by lazy { CitiesAdapter(::onCityClicked) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainViewModel: MainViewModel by activityViewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCitiesList()
        setupObservers()
    }

    private fun setupObservers() {
        mainViewModel.generatedCities.observe(viewLifecycleOwner, Observer {
            citiesAdapter.submitList(it.sortedBy { it.name })
        })
    }

    private fun setupCitiesList() {
        citiesRv.run {
            adapter = this@ListFragment.citiesAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    private fun onCityClicked(city: CityModel) {
        Toast.makeText(context, city.name, Toast.LENGTH_LONG).show()
    }
}