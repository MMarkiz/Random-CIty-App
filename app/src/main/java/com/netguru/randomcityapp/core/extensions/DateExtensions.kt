@file:Suppress("SpellCheckingInspection", "SimpleDateFormat")

package com.netguru.randomcityapp.core.extensions

import com.netguru.randomcityapp.core.Constants.DATE_TIME_FORMAT
import java.text.SimpleDateFormat
import java.util.*

fun Long.getDateTimeFromTimestamp(): String {
    return SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault()).format(Date(this))
}