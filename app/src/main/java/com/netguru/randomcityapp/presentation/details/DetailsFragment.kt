package com.netguru.randomcityapp.presentation.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentDetailsBinding
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

	override val layoutId: Int
		get() = R.layout.fragment_details

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		button_second.setOnClickListener {
			findNavController().navigate(R.id.action_DetailsFragment_to_FirstFragment)
		}
	}
}