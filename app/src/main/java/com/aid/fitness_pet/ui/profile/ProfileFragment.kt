package com.aid.fitness_pet.ui.profile

import android.os.Bundle
import android.view.View
import com.aid.fitness_pet.databinding.FragmentProfileBinding
import com.aid.fitness_pet.ui.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    ProfileViewModel::class.java,
    { FragmentProfileBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}