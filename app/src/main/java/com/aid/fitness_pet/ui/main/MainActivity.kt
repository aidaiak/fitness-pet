package com.aid.fitness_pet.ui.main

import android.os.Bundle
import com.aid.fitness_pet.databinding.ActivityMainBinding
import com.aid.fitness_pet.extensions.showToast
import com.aid.fitness_pet.ui.base.BaseActivity
import com.aid.fitness_pet.ui.base.BaseEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity: BaseActivity<MainVM, ActivityMainBinding>(
    MainVM::class.java,
    { ActivityMainBinding.inflate(it)}
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        binding.run {
            button.setOnClickListener {
                vm.getUser()
            }
        }
    }

    private fun subscribeToLiveData(){
        vm.user.observe(this,{
            showToast(it.toString())
        })

        vm.event.observe(this,{
            when(it){
                is BaseEvent.ShowToast -> showToast(it.message)
            }
        })
    }


}

