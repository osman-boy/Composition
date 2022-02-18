package com.android.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.composition.R
import com.android.composition.databinding.FragmentGameBinding
import com.android.composition.databinding.FragmentGameFinishedBinding


class GameFragmentFinished : Fragment() {


    private var _binding: FragmentGameFinishedBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("${javaClass.simpleName} == null")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding= FragmentGameFinishedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragmentFinished().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}