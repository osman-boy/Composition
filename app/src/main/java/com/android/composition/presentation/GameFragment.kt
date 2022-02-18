package com.android.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.composition.databinding.FragmentGameBinding
import com.android.composition.domain.entity.Level


class GameFragment : Fragment() {

    private lateinit var level: Level

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("${javaClass.name} == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    private fun parseArguments() {
        requireArguments().getParcelable<Level>(LEVEL)?.let { level=it }
    }

    companion object {
        private const val LEVEL = "level"

        @JvmStatic
        fun newInstance(level: Level) = GameFragment().apply {
            arguments = Bundle().apply {
                putParcelable(LEVEL, level)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}