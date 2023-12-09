package com.rahmadev.hamba.doa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmadev.hamba.core.R
import com.rahmadev.hamba.core.domain.model.doa.Doa
import com.rahmadev.hamba.core.presentation.adapter.DoaAdapter
import com.rahmadev.hamba.core.utils.Result
import com.rahmadev.hamba.doa.databinding.FragmentDoaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoaFragment : Fragment() {

    private var _binding: FragmentDoaBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<DoaViewModel>()
    private lateinit var doaAdapter: DoaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoaBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        viewModel.getDoa().observe(viewLifecycleOwner, doaObserver)
        setupToolbar()
    }

    private val doaObserver = Observer<Result<List<Doa>>> { result ->
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

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = getString(R.string.doa)
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

    private fun setupRecyclerView(listDoa: List<Doa>) {
        doaAdapter = DoaAdapter()

        binding?.rvDoa?.apply {
            adapter = doaAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        doaAdapter.submitList(listDoa)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}