package com.netguru.randomcityapp.core.binding

import android.content.Context
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.Constants.COLOR_BLACK
import com.netguru.randomcityapp.core.Constants.COLOR_BLUE
import com.netguru.randomcityapp.core.Constants.COLOR_GREEN
import com.netguru.randomcityapp.core.Constants.COLOR_RED
import com.netguru.randomcityapp.core.Constants.COLOR_WHITE
import com.netguru.randomcityapp.core.Constants.COLOR_YELLOW
import com.netguru.randomcityapp.core.extensions.getDateTimeFromTimestamp

@BindingAdapter("dateTime")
fun dateTime(view: TextView, timestamp: Long?) {
    timestamp?.let {
        view.text = it.getDateTimeFromTimestamp()
    }
}

@BindingAdapter("textColor")
fun textColor(view: TextView, colorName: String?) {
    colorName?.let {
        view.run {
            getColorResource(context, it)?.let { colorResource ->
                setTextColor(colorResource)
            }
        }
    }
}


fun getColorResource(context: Context, colorName: String): Int? {
    return when (colorName) {
        COLOR_BLACK -> context.getColor(R.color.black)
        COLOR_WHITE -> context.getColor(R.color.white)
        COLOR_RED -> context.getColor(R.color.red)
        COLOR_BLUE -> context.getColor(R.color.blue)
        COLOR_GREEN -> context.getColor(R.color.green)
        COLOR_YELLOW -> context.getColor(R.color.yellow)
        else -> null
    }
}