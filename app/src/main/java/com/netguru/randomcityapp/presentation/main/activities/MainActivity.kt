package com.netguru.randomcityapp.presentation.main.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.presentation.main.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory
	private val viewModel: MainViewModel by viewModels { viewModelFactory }


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onResume() {
		super.onResume()
		viewModel.startCityGenerator()
	}

	override fun onPause() {
		super.onPause()
		viewModel.stopCityGenerator()
	}
}