package com.netguru.randomcityapp

import com.netguru.randomcityapp.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MyApplication : DaggerApplication() {

    private lateinit var component: AndroidInjector<MyApplication>

    override fun applicationInjector(): AndroidInjector<MyApplication> {
        if (!::component.isInitialized) {
            component = DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
        }
        return component
    }
}