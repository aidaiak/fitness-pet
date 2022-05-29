package com.aid.fitness_pet.ui.schedule

import com.aid.fitness_pet.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor() : BaseVM() {
    private val calendar = Calendar.getInstance()

    fun onPrev() {
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        loadData()
    }

    fun onNext() {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        loadData()
    }

    fun getCurrentDate(): Calendar {
        return calendar
    }

    fun setNewDate(year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        loadData()
    }

    private fun loadData() {

    }
}