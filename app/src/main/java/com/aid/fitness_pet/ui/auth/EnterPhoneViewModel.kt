package com.aid.fitness_pet.ui.auth

import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterPhoneViewModel @Inject constructor() : BaseVM() {
    private var phoneNumber: String? = null

    fun setOnTextChanged(text: String) {
        this.phoneNumber = text
    }

    fun setConfirm() {
        if (phoneNumber.isNullOrEmpty()) {
            _event.postValue(BaseEvent.ShowToast("Phone Number Must be Filled"))
            return
        }
        showLoading()
        Thread.sleep(2000)
        _event.postValue(AuthEvent.OnAuthSuccess)
        hideLoading()
    }
}