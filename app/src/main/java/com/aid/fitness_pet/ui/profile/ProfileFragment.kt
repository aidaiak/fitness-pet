package com.aid.fitness_pet.ui.profile

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.aid.fitness_pet.databinding.FragmentProfileBinding
import com.aid.fitness_pet.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    ProfileViewModel::class.java,
    { FragmentProfileBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userNameTextView.doAfterTextChanged {
            vm.onUserNameChanged(it.toString())
        }
        binding.numberTextView.doAfterTextChanged {
            vm.onPhoneNumberChanged(it.toString())
        }
        binding.dateTextView.doAfterTextChanged {
            vm.onDateChanged(it.toString())
        }
        binding.trainerTextView.doAfterTextChanged {
            vm.onTrainerChanged(it.toString())
        }

        binding.actionButton.setOnClickListener {
            vm.save()
        }
        vm.user.observe(viewLifecycleOwner) {
            binding.userNameTextView.setText(it?.name)
            binding.numberTextView.setText(it?.number)
            binding.dateTextView.setText(it?.date)
            binding.trainerTextView.setText(it?.trainer)
        }
    }
}