package com.rahmadev.hamba.quran.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmadev.hamba.core.domain.model.quran.Quran
import com.rahmadev.hamba.core.presentation.adapter.QuranAdapter
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.quran.databinding.FragmentQuranBinding
import com.rahmadev.hamba.quran.viewModel.QuranViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuranFragment : Fragment() {

    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<QuranViewModel>()
    private lateinit var quranAdapter: QuranAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuranBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        viewModel.getSurah().observe(viewLifecycleOwner, quranObserver)
    }

    private val quranObserver = Observer<Result<List<Quran>>> { result ->
        when (result) {
            is Result.Error -> {
                Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
            }
            is Result.Loading -> {}
            is Result.Success -> {
                setupRecyclerView(result.data)
            }
        }
    }

    private fun setupRecyclerView(data: List<Quran>) {
        quranAdapter = QuranAdapter { id ->
            navigateToDetail(id)
        }

        binding?.rvQuran?.apply {
            adapter = quranAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        quranAdapter.submitList(data)
    }

    private fun navigateToDetail(id: Int) {
        val action = QuranFragmentDirections.actionQuranFragmentToDetailQuranFragment(id)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}