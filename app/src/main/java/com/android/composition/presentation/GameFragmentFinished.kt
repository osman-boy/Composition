package com.android.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.composition.R
import com.android.composition.databinding.FragmentGameFinishedBinding


class GameFragmentFinished : Fragment() {

    private val args: GameFragmentFinishedArgs by navArgs()
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("${javaClass.simpleName} == null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
        val image = if (args.gameResult.winner) R.drawable.ic_smile else R.drawable.ic_sad
        binding.emojiResult.setImageResource(image)

        bindViews()

    }

    private fun bindViews() {
        with(binding) {
            emojiResult.setImageResource(getSmileResId())
            tvRequiredAnswers.text = String.format(
                getString(R.string.required_score),
                args. gameResult.gameSettings.minCountOfRightAnswers
            )
            tvScoreAnswers.text = String.format(
                getString(R.string.score_answers),
                args.gameResult.countOfRightAnswers
            )
            tvRequiredPercentage.text = String.format(
                getString(R.string.required_percentage),
                args.gameResult.gameSettings.minPercentOfRightAnswers
            )
            tvScorePercentage.text = String.format(
                getString(R.string.score_percentage),
                getPercentOfRightAnswers()
            )
        }
    }

    private fun getSmileResId() = if (args.gameResult.winner) R.drawable.ic_smile else R.drawable.ic_sad


    private fun getPercentOfRightAnswers() = with(args.gameResult) {
        if (countOfQuestions == 0) 0
         else ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()

    }

    private fun retryGame() {
        findNavController().popBackStack()
    }


    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}