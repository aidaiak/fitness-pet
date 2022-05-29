package com.aid.fitness_pet.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.aid.fitness_pet.data.models.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun insertUsers(user: List<UserEntity>): Completable

    @Insert(onConflict = REPLACE)
    fun insertUser(user: UserEntity): Completable

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): Single<UserEntity?>
}