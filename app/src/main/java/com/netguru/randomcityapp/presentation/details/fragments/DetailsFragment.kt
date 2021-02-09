package com.netguru.randomcityapp.presentation.details.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentDetailsBinding
import com.netguru.randomcityapp.presentation.details.navigators.DetailsNavigator
import com.netguru.randomcityapp.presentation.details.viewmodels.DetailsViewModel
import javax.inject.Inject

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_details

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var navigator: DetailsNavigator

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize(args.city)
        binding.viewModel = viewModel

        navigator.setClearDetailsFlag()
        handleOrientationChange()
    }

    private fun handleOrientationChange() {
        context?.resources?.getBoolean(R.bool.isTabletLandscape)?.let { isTabletLandscape ->
            if (isTabletLandscape && viewModel.wasLastTimeTabletLandscape == false) {
                viewModel.city.value?.let {
                    navigator.navigateBackToList(it)
                }
            }
            viewModel.wasLastTimeTabletLandscape = isTabletLandscape
        }
    }
}