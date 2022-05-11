package com.aid.fitness_pet.data.storage

import androidx.room.Dao
import androidx.room.Insert
import com.aid.fitness_pet.data.models.UserEntity
import io.reactivex.Completable

@Dao
interface UserDao {
    @Insert
    fun insertUsers(user: List<UserEntity>): Completable
}