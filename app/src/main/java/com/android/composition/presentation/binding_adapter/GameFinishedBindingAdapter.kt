package com.android.composition.presentation.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.composition.R
import com.android.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = textView.context.getString(R.string.required_score, count)
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count: Int) {
    textView.text = textView.context.getString(R.string.score_answers, count)
}




@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {

    fun getPercentOfRightAnswers() = with(gameResult) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }
    textView.text =
        textView.context.getString(R.string.score_percentage, getPercentOfRightAnswers())


}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, count: Int) {
    textView.text = textView.context.getString(R.string.required_percentage, count)
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView: ImageView, isWin: Boolean) {
    val emoji = if (isWin) R.drawable.ic_smile else R.drawable.ic_sad
    imageView.setImageResource(emoji)
}

