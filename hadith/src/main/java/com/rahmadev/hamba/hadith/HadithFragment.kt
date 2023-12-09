package com.rahmadev.hamba.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rahmadev.hamba.core.R
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmadev.hamba.core.domain.model.hadith.Hadith
import com.rahmadev.hamba.core.presentation.adapter.HadithAdapter
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.hadith.databinding.FragmentHadithBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HadithFragment : Fragment() {

    private var _binding: FragmentHadithBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<HadithViewModel>()
    private lateinit var hadithAdapter: HadithAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHadithBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        viewModel.getHadith().observe(viewLifecycleOwner, hadithObserver)

        setupToolbar()
    }

    private val hadithObserver = Observer<Result<List<Hadith>>> { result ->
        when(result) {
            is Result.Loading -> {}
            is Result.Success -> {
                setupRecyclerView(result.data)
            }
            is Result.Error -> {
                Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = getString(R.string.hadith)
            }
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigateUp()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.CREATED)
    }

    private fun setupRecyclerView(listHadith: List<Hadith>) {
        hadithAdapter = HadithAdapter()

        binding?.rvHadith?.apply {
            adapter = hadithAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        hadithAdapter.submitList(listHadith)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}