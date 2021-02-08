package com.netguru.randomcityapp.presentation.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

	override val layoutId: Int
		get() = R.layout.fragment_details

	private val args by navArgs<DetailsFragmentArgs>()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.city = args.city
	}
}