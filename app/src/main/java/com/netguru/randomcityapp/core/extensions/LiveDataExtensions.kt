package com.netguru.randomcityapp.core.extensions

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.applyAndSet(apply: (T?) -> T?) {
    val data: T? = value
    val transformedData = apply(data)
    value = transformedData
}