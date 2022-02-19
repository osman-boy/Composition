package com.android.composition.presentation.binding_adapter

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter


/**
 * Created by osmanboy on 2/19/2022.
 */

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("enoughCountColor")
fun bindEnoughCountColor(textView: TextView, isEnough:Boolean){
    textView.setTextColor(getColorByState(isEnough, textView.context))
}

@BindingAdapter("enoughPercentColor")
fun bindEnoughPercentColor(progressBar: ProgressBar, isEnough:Boolean){
    progressBar.progressTintList =
        ColorStateList.valueOf(getColorByState(isEnough, progressBar.context))

}
@BindingAdapter("setProgress")
fun setProgressOfRightAnswers(progressBar: ProgressBar, progress:Int){
    progressBar.setProgress(progress, true)

}

fun getColorByState(goodState: Boolean,context: Context): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_dark
    } else {
        android.R.color.holo_red_dark

    }

    return ContextCompat.getColor(context, colorResId)
}



@BindingAdapter("numberAsText")
fun bindSum(textView: TextView,number:Int){
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOptionClick(textView: TextView,listener: OnOptionClickListener){

    textView.setOnClickListener {
        listener.onOptionClick(textView.text.toString().toInt())
    }
}