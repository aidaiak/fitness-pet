package com.aid.fitness_pet.domain.use_cases

import com.aid.fitness_pet.data.repo.ScheduleRepo
import com.aid.fitness_pet.ui.schedule.Schedule
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ScheduleUseCase @Inject constructor(
    private val scheduleRepo: ScheduleRepo
) {

    operator fun invoke(): Single<List<Schedule>> {
        return scheduleRepo.getSchedules()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}