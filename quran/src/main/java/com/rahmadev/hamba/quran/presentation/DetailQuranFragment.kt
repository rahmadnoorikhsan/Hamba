package com.rahmadev.hamba.quran.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmadev.hamba.core.domain.model.quran.Surah
import com.rahmadev.hamba.core.domain.model.quran.Verses
import com.rahmadev.hamba.core.presentation.adapter.VerseAdapter
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.quran.R
import com.rahmadev.hamba.quran.databinding.FragmentDetailQuranBinding
import com.rahmadev.hamba.quran.viewModel.DetailQuranViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailQuranFragment : Fragment() {

    private var _binding: FragmentDetailQuranBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<DetailQuranViewModel>()
    private val navArgs by navArgs<DetailQuranFragmentArgs>()
    private lateinit var verseAdapter: VerseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailQuranBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idArgs = navArgs.id

        viewModel.getSurahById(idArgs).observe(viewLifecycleOwner, verseObserver)
    }

    private val verseObserver = Observer<Result<Surah>> { result ->
        when (result) {
            is Result.Error -> {
                Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
            }
            is Result.Loading -> {}
            is Result.Success -> {
                setupRecycler(result.data)
                setupView(result.data)
            }
        }
    }

    private fun setupRecycler(data: Surah) {
        verseAdapter = VerseAdapter()

        binding?.rvSurah?.apply {
            adapter = verseAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        verseAdapter.submitList(data.verses)
    }

    private fun setupView(surah: Surah) {
        binding?.cardSurah?.apply {
            tvSurah.text = surah.name
            tvDescription.text =
                getString(R.string.description, surah.type, surah.verses.size.toString(), surah.translate)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}