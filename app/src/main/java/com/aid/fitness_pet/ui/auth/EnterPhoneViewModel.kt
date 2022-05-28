package com.aid.fitness_pet.ui.auth

import com.aid.fitness_pet.data.storage.Preferences
import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class EnterPhoneViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseVM() {
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
        disposable.add(
            Completable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        preferences.phoneNumber = phoneNumber
                        _event.postValue(AuthEvent.OnAuthSuccess)
                        hideLoading()
                    }, {
                        _event.value = BaseEvent.ShowToast(it.message ?: "")
                        hideLoading()
                    }
                )
        )
    }
}