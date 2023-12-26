package com.rahmadev.hamba.adzan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmadev.hamba.adzan.databinding.FragmentAdzanBinding
import com.rahmadev.hamba.core.R
import com.rahmadev.hamba.core.data.source.dummy.AdzansData
import com.rahmadev.hamba.core.presentation.adapter.AdzanAdapter

class AdzanFragment : Fragment() {

    private var _binding: FragmentAdzanBinding? = null
    private val binding get() = _binding
    private val adzanAdapter by lazy { AdzanAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAdzanBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupRecycler()
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = getString(R.string.adzan)
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

    private fun setupRecycler() {
        val data = AdzansData.dummyAdzan

        binding?.rvAdzan?.apply {
            adapter = adzanAdapter
            layoutManager = LinearLayoutManager(context)
        }

        adzanAdapter.submitList(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}