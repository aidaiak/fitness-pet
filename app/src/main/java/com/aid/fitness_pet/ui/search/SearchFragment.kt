package com.aid.fitness_pet.ui.search

import android.os.Bundle
import android.view.View
import com.aid.fitness_pet.databinding.FragmentSearchBinding
import com.aid.fitness_pet.ui.base.BaseFragment

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(
    SearchViewModel::class.java,
    { FragmentSearchBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}