package com.aid.fitness_pet.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aid.fitness_pet.domain.models.User
import com.aid.fitness_pet.domain.use_cases.GetUserUseCase
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getUserUseCase: GetUserUseCase
): BaseVM() {

    private val _user =  MutableLiveData<List<User>>()
    val user: LiveData<List<User>>
        get() = _user

    fun getUser(){
        disposable.add(
            getUserUseCase()
                .subscribe({
                    _user.value = it
                },{
                    _event.value = BaseEvent.ShowToast(it.message ?: "")
                })
        )
    }
}