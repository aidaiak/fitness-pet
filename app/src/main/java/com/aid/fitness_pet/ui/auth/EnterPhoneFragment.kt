package com.aid.fitness_pet.ui.auth

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.aid.fitness_pet.databinding.FragmentEnterPhoneBinding
import com.aid.fitness_pet.extensions.replace
import com.aid.fitness_pet.extensions.showKeyboard
import com.aid.fitness_pet.extensions.showToast
import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseFragment
import com.aid.fitness_pet.ui.sms.EnterCodeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterPhoneFragment : BaseFragment<EnterPhoneViewModel, FragmentEnterPhoneBinding>(
    EnterPhoneViewModel::class.java,
    { FragmentEnterPhoneBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backImageView.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        binding.editText.doAfterTextChanged {
            vm.setOnTextChanged(it.toString())
        }
        binding.actionButton.setOnClickListener {
            vm.setConfirm()
        }
        vm.event.observe(viewLifecycleOwner) {
            when (it) {
                AuthEvent.OnAuthSuccess -> replace(EnterCodeFragment())
                is BaseEvent.ShowToast -> requireContext().showToast(it.message)
            }
        }
        vm.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        binding.editText.showKeyboard()
    }
}