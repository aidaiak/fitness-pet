package com.aid.fitness_pet.ui.sms

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.aid.fitness_pet.databinding.FragmentEnterCodeBinding
import com.aid.fitness_pet.extensions.replace
import com.aid.fitness_pet.extensions.showKeyboard
import com.aid.fitness_pet.extensions.showToast
import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseFragment
import com.aid.fitness_pet.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterCodeFragment : BaseFragment<EnterCodeViewModel, FragmentEnterCodeBinding>(
    EnterCodeViewModel::class.java,
    { FragmentEnterCodeBinding.inflate(it) }
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
                AuthEvent.OnAuthSuccess -> replace(HomeFragment())
                is BaseEvent.ShowToast -> requireContext().showToast(it.message)
            }
        }
        vm.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        binding.editText.showKeyboard()
    }
}