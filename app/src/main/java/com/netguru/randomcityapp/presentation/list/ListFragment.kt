package com.netguru.randomcityapp.presentation.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : BaseFragment<FragmentListBinding>() {

	override val layoutId: Int
		get() = R.layout.fragment_list

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		button_first.setOnClickListener {
			findNavController().navigate(R.id.action_ListFragment_to_DetailsFragment)
		}
	}
}