package com.aid.fitness_pet.data.repo

import com.aid.fitness_pet.data.network.ScheduleApi
import javax.inject.Inject

class ScheduleRepo @Inject constructor(
    private var scheduleApi: ScheduleApi
) {
    fun getSchedules() = scheduleApi.getSchedules()

}