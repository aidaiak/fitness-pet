package com.aid.fitness_pet.ui.profile

import androidx.lifecycle.MutableLiveData
import com.aid.fitness_pet.data.models.UserEntity
import com.aid.fitness_pet.data.storage.UserDao
import com.aid.fitness_pet.ui.base.AuthEvent
import com.aid.fitness_pet.ui.base.BaseEvent
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dao: UserDao
) : BaseVM() {
    private var username: String = ""
    private var number: String = ""
    private var date: String = ""
    private var trainer: String = ""
    val user = MutableLiveData<UserEntity?>()

    fun onUserNameChanged(text: String) {
        this.username = text
    }

    fun onPhoneNumberChanged(text: String) {
        this.number = text
    }

    fun onDateChanged(text: String) {
        this.date = text
    }

    fun onTrainerChanged(text: String) {
        this.trainer = text
    }

    init {
        loadData()
    }

    private fun loadData() {
        disposable.add(
            dao.getUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    user.postValue(it)
                }, {
                    it.printStackTrace()
                }
                )
        )
    }

    fun save() {
        showLoading()
        disposable.add(
            dao.insertUser(UserEntity(name = username, number = number, date = date, trainer = trainer))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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