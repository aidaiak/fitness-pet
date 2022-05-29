package com.aid.fitness_pet.extensions

import com.aid.fitness_pet.data.models.UserDto
import com.aid.fitness_pet.data.models.UserEntity
import com.aid.fitness_pet.domain.models.User

fun UserDto.toUserEntity(): UserEntity {
    return UserEntity(
        id,
        name,
        number,
        date,
        trainer
    )
}


fun UserDto.toUser(): User {
    return User(
        id,
        name,
        number,
        date,
        trainer
    )
}