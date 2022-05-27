package com.aid.fitness_pet.ui.sms

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.aid.fitness_pet.databinding.FragmentEnterCodeBinding
import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseFragment
import com.aid.fitness_pet.ui.home.HomeFragment
import com.aid.fitness_pet.ui.replace

class EnterCodeFragment : BaseFragment<EnterCodeViewModel, FragmentEnterCodeBinding>(
    EnterCodeViewModel::class.java,
    { FragmentEnterCodeBinding.inflate(it) }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editText.doAfterTextChanged {
            vm.setOnTextChanged(it.toString())
        }
        binding.actionButton.setOnClickListener {
            vm.setConfirm()
        }
        binding.backImageView.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        vm.event.observe(viewLifecycleOwner) {
            when (it) {
                AuthEvent.OnAuthSuccess -> replace(HomeFragment())
                is BaseEvent.ShowToast -> Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        vm.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }
}