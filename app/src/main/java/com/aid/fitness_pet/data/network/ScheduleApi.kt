package com.aid.fitness_pet.data.network

import com.aid.fitness_pet.ui.schedule.Schedule
import io.reactivex.Single
import retrofit2.http.GET

interface ScheduleApi {

    @GET("schedule")
    fun getSchedules(): Single<List<Schedule>>
}