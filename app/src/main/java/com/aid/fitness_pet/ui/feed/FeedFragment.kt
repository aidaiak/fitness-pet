package com.aid.fitness_pet.ui.feed

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.aid.fitness_pet.databinding.FragmentFeedBinding
import com.aid.fitness_pet.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : BaseFragment<FeedViewModel, FragmentFeedBinding>(
    FeedViewModel::class.java,
    { FragmentFeedBinding.inflate(it) }
) {
    private val adapter = Adapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        vm.loadData().observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
        vm.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }
}