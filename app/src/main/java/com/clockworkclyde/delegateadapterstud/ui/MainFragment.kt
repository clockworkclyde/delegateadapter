package com.clockworkclyde.delegateadapterstud.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.clockworkclyde.delegateadapterstud.R
import com.clockworkclyde.delegateadapterstud.adapter.FlightInfoDelegateAdapter
import com.clockworkclyde.delegateadapterstud.adapter.PassengerInfoDelegateAdapter
import com.clockworkclyde.delegateadapterstud.adapter.RefundInfoDelegateAdapter
import com.clockworkclyde.delegateadapterstud.databinding.FragmentMainBinding
import com.clockworkclyde.delegateadapterstud.delegate.CompositeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(FlightInfoDelegateAdapter())
            .add(PassengerInfoDelegateAdapter { })
            .add(RefundInfoDelegateAdapter())
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = compositeAdapter
        viewModel.listItems.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            compositeAdapter.submitList(it)
        })
    }
}