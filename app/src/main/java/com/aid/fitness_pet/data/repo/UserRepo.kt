package com.aid.fitness_pet.data.repo

import com.aid.fitness_pet.data.models.UserEntity
import com.aid.fitness_pet.data.network.UserApi
import com.aid.fitness_pet.data.storage.UserDao
import javax.inject.Inject

class UserRepo @Inject constructor(
    private var userDao: UserDao,
    private var userApi: UserApi
) {

    fun getUserFromApi() = userApi.getUsers()

    fun saveUsersToDb(users: List<UserEntity>) = userDao.insertUsers(users)
}