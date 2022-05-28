package com.aid.fitness_pet.ui.main

import com.aid.fitness_pet.data.storage.Preferences
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseVM() {

    fun isInitialSetup() = !preferences.containsPhoneNumber()
}