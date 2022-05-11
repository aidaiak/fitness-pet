package com.aid.fitness_pet.data.network

import com.aid.fitness_pet.data.models.UserDto
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {

    @GET("example/get_users")
    fun getUsers(): Single<List<UserDto>>
}