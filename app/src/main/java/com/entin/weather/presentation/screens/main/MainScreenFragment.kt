package com.entin.weather.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.entin.weather.databinding.FragmentMainScreenBinding
import com.entin.weather.presentation.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        observeForecast()

        return binding.root
    }

    private fun observeForecast() {
        observe(viewModel.stateScreen) { result ->
            setState(result)
        }
    }

    private fun setState(result: Any) {
        // Not yet implemented
    }
}
