package com.aid.fitness_pet.ui.sms

import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class EnterCodeViewModel @Inject constructor() : BaseVM() {
    private var smsCode: String? = null

    fun setOnTextChanged(text: String) {
        this.smsCode = text
    }

    fun setConfirm() {
        if (smsCode.isNullOrEmpty()) {
            _event.postValue(BaseEvent.ShowToast("Sms code Must be Filled"))
            return
        }
        showLoading()
        disposable.add(
            Completable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(
                    {
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