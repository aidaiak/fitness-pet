package com.aid.fitness_pet.ui.main

import android.os.Bundle
import com.aid.fitness_pet.databinding.ActivityMainBinding
import com.aid.fitness_pet.extensions.replace
import com.aid.fitness_pet.ui.auth.EnterPhoneFragment
import com.aid.fitness_pet.ui.base.BaseActivity
import com.aid.fitness_pet.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    MainViewModel::class.java,
    { ActivityMainBinding.inflate(it) }
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (vm.isInitialSetup()) {
            replace(EnterPhoneFragment())
        } else {
            replace(HomeFragment())
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}