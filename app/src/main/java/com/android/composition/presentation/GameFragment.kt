package com.android.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.composition.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private val viewModel by viewModels<GameViewModel> {
        GameViewModelFactory(requireActivity().application, args.level) }

    private val args by navArgs<GameFragmentArgs>()


    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        _binding = FragmentGameBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.gameResult.observe(viewLifecycleOwner) {
            findNavController()
                .navigate(GameFragmentDirections.actionGameFragmentToGameFragmentFinished(it))
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
