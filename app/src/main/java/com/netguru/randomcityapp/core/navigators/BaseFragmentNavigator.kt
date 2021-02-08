package com.netguru.randomcityapp.core.navigators

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.lang.ref.WeakReference

abstract class BaseFragmentNavigator<T : Fragment>(fragment: T) {

    private val weakFragment = WeakReference(fragment)

    protected val fragment
        get() = weakFragment.get()

    protected val navController
        get() = fragment?.findNavController()
}