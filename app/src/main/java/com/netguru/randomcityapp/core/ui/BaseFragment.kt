package com.netguru.randomcityapp.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.netguru.randomcityapp.presentation.main.activities.MainActivity
import dagger.android.support.DaggerFragment

abstract class BaseFragment<TViewBinding : ViewDataBinding> : DaggerFragment() {

    private var innerBinding: TViewBinding? = null
    protected val binding: TViewBinding get() = innerBinding ?: throw IllegalStateException("Trying to access the binding outside of the lifecycle.")

    abstract val layoutId: Int

    protected val baseActivity: MainActivity
        get() = activity as MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        innerBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        innerBinding = null
    }
}