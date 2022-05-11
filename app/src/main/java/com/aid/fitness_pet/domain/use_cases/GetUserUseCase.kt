package com.aid.fitness_pet.domain.use_cases

import com.aid.fitness_pet.data.repo.UserRepo
import com.aid.fitness_pet.domain.models.User
import com.aid.fitness_pet.extensions.toUser
import com.aid.fitness_pet.extensions.toUserEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepo: UserRepo
) {

    operator fun invoke(): Single<List<User>> {
        return userRepo.getUserFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                userRepo.saveUsersToDb(it.map { it.toUserEntity() })
                it.map { it.toUser() }
            }
            .observeOn(AndroidSchedulers.mainThread())

    }
}