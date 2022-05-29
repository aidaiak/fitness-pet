package com.aid.fitness_pet.ui.schedule

import androidx.lifecycle.MutableLiveData
import com.aid.fitness_pet.domain.use_cases.ScheduleUseCase
import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val useCase: ScheduleUseCase
) : BaseVM() {
    private val calendar = Calendar.getInstance()
    val calendarState = MutableLiveData(calendar)
    val items = MutableLiveData<List<Schedule>>(emptyList())

    fun onPrev() {
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        calendarState.postValue(calendar)
        loadData()
    }

    fun onNext() {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        calendarState.postValue(calendar)
        loadData()
    }

    fun getCurrentDate(): Calendar {
        return calendar
    }

    fun setNewDate(year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        calendarState.postValue(calendar)
        loadData()
    }

    fun loadData() {
        showLoading()
        disposable.add(
            useCase.invoke()
                .subscribe({
                    items.postValue(it)
                    hideLoading()
                }, {
                    it.printStackTrace()
                    hideLoading()
                })
        )
    }
}