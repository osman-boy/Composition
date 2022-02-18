package com.android.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.composition.R
import com.android.composition.databinding.FragmentChooseLevelBinding
import com.android.composition.domain.entity.Level


class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("${javaClass.simpleName} == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLevelTest.setOnClickListener { launchGameFragment(Level.TEST) }
            buttonLevelEasy.setOnClickListener { launchGameFragment(Level.EASY) }
            buttonLevelNormal.setOnClickListener { launchGameFragment(Level.NORMAL) }
            buttonLevelHard.setOnClickListener { launchGameFragment(Level.HARD) }
        }
    }

    private fun launchGameFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment.newInstance(level))
            .addToBackStack(NAME)

            .commit()
    }

    companion object {

        val NAME: String = javaClass.simpleName

        @JvmStatic
        fun newInstance() =
            ChooseLevelFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}