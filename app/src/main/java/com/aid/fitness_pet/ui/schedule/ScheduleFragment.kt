package com.aid.fitness_pet.ui.schedule

import android.os.Bundle
import android.view.View
import com.aid.fitness_pet.databinding.FragmentScheduleBinding
import com.aid.fitness_pet.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleFragment : BaseFragment<ScheduleViewModel, FragmentScheduleBinding>(
    ScheduleViewModel::class.java,
    { FragmentScheduleBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}