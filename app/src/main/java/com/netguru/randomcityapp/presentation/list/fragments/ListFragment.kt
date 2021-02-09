package com.netguru.randomcityapp.presentation.list.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.netguru.domain.CityModel
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentListBinding
import com.netguru.randomcityapp.presentation.list.adapters.CitiesAdapter
import com.netguru.randomcityapp.presentation.list.navigators.ListNavigator
import com.netguru.randomcityapp.presentation.list.viewmodels.ListViewModel
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
    private val viewModel: ListViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var navigator: ListNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCitiesList()
        setupObservers()
        if(navigator.getClearSelectedCityFlag() == true){
            viewModel.clearSelectedCity()
        }
    }

    private fun setupObservers() {
        mainViewModel.generatedCities.observe(viewLifecycleOwner, Observer {
            citiesAdapter.submitList(it.sortedBy { it.name })
        })

        viewModel.selectedCity.observe(viewLifecycleOwner, Observer {
            it?.let { navigator.navigateToDetails(it) } //?: navigator.clearDetailsFragmentContainer()
        })
    }

    private fun setupCitiesList() {
        citiesRv.run {
            adapter = this@ListFragment.citiesAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun onCityClicked(city: CityModel) {
        viewModel.changeSelectedCity(city)
    }

    override fun onDestroyView() {
        citiesRv.adapter = null
        super.onDestroyView()
    }
}