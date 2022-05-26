package com.aid.fitness_pet.ui.sms

import android.os.Bundle
import android.view.View
import com.aid.fitness_pet.databinding.FragmentEnterCodeBinding
import com.aid.fitness_pet.ui.base.BaseFragment

class EnterCodeFragment : BaseFragment<EnterCodeViewModel, FragmentEnterCodeBinding>(
    EnterCodeViewModel::class.java,
    { FragmentEnterCodeBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionButton.setOnClickListener {

        }
    }
}