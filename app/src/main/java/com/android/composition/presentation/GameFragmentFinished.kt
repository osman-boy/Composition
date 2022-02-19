package com.android.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.composition.databinding.FragmentGameFinishedBinding


class GameFragmentFinished : Fragment() {

    private val args: GameFragmentFinishedArgs by navArgs()
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("${javaClass.name} == null")


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        _binding = FragmentGameFinishedBinding.inflate(layoutInflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gameResult = args.gameResult

        binding.buttonRetry.setOnClickListener {
            findNavController().popBackStack()
        }

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}